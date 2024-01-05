package ru.preminin.december.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    private List<ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.printf("Сервер запущен на порту: %d. Ожидание подключения клиентов.\n", port);
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    subscribe(new ClientHandler(this, socket));
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("failed to connect the client");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        System.out.println("Connected " + clientHandler.getUserName());
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        System.out.println("Disconnected " + clientHandler.getUserName());
    }

    public synchronized void sendPrivateMessage(ClientHandler sender, String receivedUserName, String message) {
        for (ClientHandler client : clients) {
            if (client.getUserName().equals(receivedUserName)) {
                client.sendMessage(sender.getUserName() + " send private message: " + message);
                sender.sendMessage("Private message received for " + client.getUserName() + " : " + message);
            }
        }
    }

}
