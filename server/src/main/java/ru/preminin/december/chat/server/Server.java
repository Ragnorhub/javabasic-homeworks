package ru.preminin.december.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    private List<ClientHandler> clients;
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.printf("Сервер запущен на порту: %d. Ожидание подключения клиентов.\n", port);
            userService = new InMemoryUserService();
            System.out.println("Запущен сервис для работы с пользователями.");
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    new ClientHandler(this, socket);
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
        broadcastMessage("Connected " + clientHandler.getUserName());
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage("Disconnected " + clientHandler.getUserName());
    }

    public synchronized boolean isUserBusy(String username) {
        for (ClientHandler c : clients) {
            if (c.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void sendPrivateMessage(ClientHandler sender, String receivedUserName, String message) {
        for (ClientHandler client : clients) {
            if (client.getUserName().equals(receivedUserName)) {
                client.sendMessage(sender.getUserName() + " send private message: " + message);
                sender.sendMessage("Private message received for " + client.getUserName() + " : " + message);
            }
        }
    }
    public synchronized ClientHandler findUser(String user) {
        for (ClientHandler client : clients) {
            if (client.getUserName().equals(user)) {
                return client;
            }
        }
        return null;
    }
}
