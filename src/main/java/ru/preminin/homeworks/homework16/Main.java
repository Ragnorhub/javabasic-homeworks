package ru.preminin.homeworks.homework16;

import java.util.Arrays;

/**
 * Необходимо выполнить две реализации задачи заполнения массива
 * Реализация №1
 * Реализуйте метод, который создает double массив длиной 100_000_000 элементов
 * Метод должен должен циклом for пройти по каждому элементу и посчитать его значение по формуле:
 * array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
 * Засеките время выполнения цикла и выведите его в консоль.
 * Реализация №2:
 * Сделайте то же самое что и в реализации один, только чтобы массив заполняли 4 потока одновременно.
 * То есть первый поток заполняет первую четверть массива, второй - вторую и т.д.
 * И посмотрите насколько быстрее выполнится работа по сравнению с одним потоком.
 */

public class Main {
    public static void main(String[] args) {
        oneThread(new Double[100_000_000]);
        multiThread(new Double[100_000_000]);
    }

    public static void oneThread(Double[] arr) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        System.out.println("Время выполнения однопотока: " + (System.currentTimeMillis() - time1) + " миллисекунд");
    }

    public static void multiThread(Double[] arr) {
        long time2 = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr.length / 4; i++) {
                arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = arr.length / 4; i < arr.length / 4; i++) {
                arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = arr.length / 2; i < arr.length / 4; i++) {
                arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = arr.length * 3 / 4; i < arr.length / 4; i++) {
                arr[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        for (Thread thread : Arrays.asList(t1, t2, t3, t4)) {
            thread.start();
        }
        for (Thread thread : Arrays.asList(t1, t2, t3, t4)) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Время выполнения многопотока: " + (System.currentTimeMillis() - time2) + " миллисекунд");
    }
}