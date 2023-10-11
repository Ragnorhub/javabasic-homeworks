package ru.preminin.homeworks.homework3;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the program number(1-5):\n1-Greetings\n2-Check Sign\n3-Select Color" +
                "\n4-Compare Numbers\n5-Add or Substract and Print");
        switch (scanner.nextInt()) {
            case 1:
                greetings();
                break;
            case 2:
                checkSign(random(7), random(3), 3);
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            case 5:
                addOrSubtractAndPrint(random(101), random(101), random(10) > 5);
                break;
            default:
                System.out.println("Enter wrong number. Application closed");
                break;
        }
    }

    public static int random(int range) {
        return (int) (Math.random() * range);
    }

    public static void greetings() {
        System.out.println("Hello \nWorld \nfrom \nJava");
    }

    public static void checkSign(int a, int b, int c) {
        if (a + b + c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = random(31);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = random(101);
        int b = random(101);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}
