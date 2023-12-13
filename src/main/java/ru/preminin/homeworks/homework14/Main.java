package ru.preminin.homeworks.homework14;

import java.io.File;
import java.util.*;

/**
 * Реализуйте приложение, позволяющее работать с текстовыми файлами
 * При старте приложения, в консоль выводится список текстовых файлов из корневого каталоге проекта
 * Далее программа запрашивает имя файла, с которым хочет работать пользователь
 * Содержимое файла выводится в консоль
 * Затем любую введенную пользователем строку необходимо записывать в указанный файл
 */

public class Main {
    public static void main(String[] args) {
        FileCommandHandler file = new FileCommandHandler();
        file.createFile("out1.txt", "Hello Roman", false);
        file.createFile("out2.txt", "Hello Otus", false);
        file.createFile("out3.txt", "Hello Universe", false);

        File folder = new File(".");
        File[] listFiles = folder.listFiles();
        List<String> nameOfFiles = new ArrayList<>();
        for (File files : Objects.requireNonNull(listFiles)) {
            if (files.isFile()) {
                nameOfFiles.add(files.getName());
                System.out.println(files.getName());
            }
        }

        System.out.println("Enter the name of the file to process: ");

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        if (nameOfFiles.contains(fileName)) {
            file.printFile(fileName);
        } else {
            System.out.println("The file does not exist");
            return;
        }

        System.out.println("Enter a line to add to the file: ");
        String toWrite = scanner.nextLine();

        file.createFile(fileName, toWrite, true);
        file.printFile(fileName);
    }
}


