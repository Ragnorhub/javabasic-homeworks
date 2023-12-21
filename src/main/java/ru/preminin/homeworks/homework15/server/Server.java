package ru.preminin.homeworks.homework15.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(8088);
                System.out.println("Сервер запущен!");
                clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = in.readLine();
                    String[] words = word.split(" ");
                    float firstNumber = Float.parseFloat(words[0]);
                    float secondNumber = Float.parseFloat(words[2]);
                    switch (words[1]) {
                        case "+":
                            out.write("Результат действия : " + word + " = " + (firstNumber+secondNumber) + "\n");
                        case "-":
                            out.write("Результат действия : " + word + " = " + (firstNumber-secondNumber) + "\n");
                        case "*":
                            out.write("Результат действия : " + word + " = " + (firstNumber*secondNumber) + "\n");
                        case "/":
                            out.write("Результат действия : " + word + " = " + (firstNumber/secondNumber) + "\n");
                    }
                    out.flush();

                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}