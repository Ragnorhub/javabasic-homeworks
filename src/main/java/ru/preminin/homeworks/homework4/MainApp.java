package ru.preminin.homeworks.homework4;

import java.util.Arrays;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        //stringRepeater(5,"Hello");
        //System.out.println(Arrays.toString(randomArray()));
        //sumIfFive(randomArray());
        //System.out.println(Arrays.toString(randomArray()));
        //System.out.println(Arrays.toString(arrayOfNumber(5, randomArray())));
        //System.out.println(Arrays.toString(arrayOfMultiple(5, randomArray())));
        //comparingArrayParts(randomArray());
        reverseArray(randomArray());
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

    public static void stringRepeater(int repeater, String line) {
        for (int i = 0; i < repeater; i++) {
            System.out.println(line);
        }
    }

    public static void sumIfFive(int[] array) {
        int sum = 0;
        for (int num : array) {
            if (num > 5) {
                sum += num;
            }
        }
        System.out.println(sum);
        ;
    }

    public static int[] arrayOfNumber(int number, int[] array) {
        Arrays.fill(array, number);
        return array;
    }

    public static int[] arrayOfMultiple(int number, int[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] *= number;
        }
        return array;
    }

    public static void comparingArrayParts(int[] array) {
        System.out.println(Arrays.toString(array));
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length / 2) {
                sumLeft += array[i];
            } else {
                sumRight += array[i];
            }
        }
        if (sumLeft > sumRight) {
            System.out.println("Левая часть массива больше");
        } else {
            System.out.println("Правая часть массива больше");
        }
    }
    public static void reverseArray (int[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}

