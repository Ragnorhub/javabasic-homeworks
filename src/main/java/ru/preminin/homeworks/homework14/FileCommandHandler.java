package ru.preminin.homeworks.homework14;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileCommandHandler {

    public void createFile(String fileName, String data, boolean append) {
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, append))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
                out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFile(String fileName) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}