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
    public String getUserName() {
        return userName;
    }

    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            System.out.println("Клиент " + userName + " подключился");
            try {
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/auth ")) {
                        String[] elements = message.split(" "); //auth login1 pass1
                        if (elements.length != 3) {
                            sendMessage("Server: Wrong authentication");
                            continue;
                        }
                        String login = elements[1];
                        String password = elements[2];
                        String usernameFromUserService = server.getUserService().getUsernameByLoginAndPassword(login, password);
                        if (usernameFromUserService == null) {
                            System.out.println("Server: the user does not exist or wrong (login/pass)");
                            sendMessage("Server: the user does not exist or wrong (login/pass)");
                            continue;
                        }
                        if (server.isUserBusy(usernameFromUserService)) {
                            System.out.println("Server: the account is already occupied");
                            sendMessage("Server: the account is already occupied");
                            continue;
                        } else {
                            sendMessage("Server: you are logged in to your account");
                        }
                        userName = usernameFromUserService;
                        server.subscribe(this);
                        sendMessage("/authok " + userName);
                        sendMessage("Server: " + userName + " welcome in to a chat");
                        break;
                    } else if (message.startsWith("/reg ")) {
                        String[] elements = message.split(" "); // /reg login1 pass1 user1
                        if (elements.length != 5) {
                            sendMessage("Server: Wrong authentication");
                            continue;
                        }
                        String login = elements[1];
                        String password = elements[2];
                        String registrationUsername = elements[3];
                        String role = elements[4];
                        if (server.getUserService().isLoginAlreadyExist(login)) {
                            sendMessage("Server: This login is already exist");
                            continue;
                        }
                        if (server.getUserService().isUsernameAlreadyExist(registrationUsername)) {
                            sendMessage("Server: This username is already exist");
                            continue;
                        }
                        if (!role.equals("User")) {
                            sendMessage("You have specified the wrong role. When registering, specify the USER");
                        }
                        server.getUserService().createNewUser(login, password, registrationUsername, role);
                        userName = registrationUsername;
                        sendMessage("/authok " + userName);
                        sendMessage("Server: " + userName + " Successful registration, welcome in to a chat");
                        server.subscribe(this);
                        break;
                    } else {
                        sendMessage("Server: you need to log in to your account or register");
                    }
                }
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
                        if (message.startsWith("/kick ") && server.getUserService().getUserRoleByName(this.userName).equals("ADMIN")) {
                            disconnect(server.findUser(messageSplit[1]));
                            continue;
                        }
                    }
                    server.broadcastMessage(userName + " : " + message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                disconnect(this);
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

    public void disconnect(ClientHandler clientHandler) {
        server.unsubscribe(clientHandler);
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
