package ru.preminin.homeworks.homework4;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        stringRepeater(5,"Hello");
        System.out.println(Arrays.toString(randomArray()));
    }

    public static void stringRepeater(int repeater, String line) {
        for (int i = 0; i < repeater; i++) {
            System.out.println(line);
        }
    }
    public static int random(int range) {
        return (int) (Math.random() * range);
    }
    public static int[] randomArray() {
        int[] array = new int[random(15)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random(20);
        }
        return array;
    }

}

