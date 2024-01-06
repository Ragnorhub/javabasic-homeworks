package ru.preminin.december.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String userName;

    private static int clientsCount = 0;

    public String getUserName() {
        return userName;
    }

    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        clientsCount++;
        this.userName = "User" + clientsCount;
        new Thread(() -> {
            System.out.println("Клиент " + userName + " подключился");
            try {
                while (true) {
                    String message = in.readUTF();
                    String[] messageSplit = message.split(" ", 3);
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            break;
                        }
                        if (message.startsWith("/w ")) {
                            server.sendPrivateMessage(this, messageSplit[1], messageSplit[2]);
                            continue;
                        }
                    }
                    server.broadcastMessage(userName + " : " + message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
