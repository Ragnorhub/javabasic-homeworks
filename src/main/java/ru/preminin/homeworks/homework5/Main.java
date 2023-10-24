package ru.preminin.homeworks.homework5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        sumOfPositiveElements(randomTwoDimensionsArray(4));
        squareInConsole(random(8));
        diaonalsOfArray(randomTwoDimensionsArray(4));
        findMax(randomTwoDimensionsArray(4));
        System.out.println(sumSecondElementsInArray(randomTwoDimensionsArray(4)));
    }

    public static int random(int range) {
        return (int) (Math.random() * range);
    }

    public static int[][] randomTwoDimensionsArray(int deepOfArray) {
        int[][] array = new int[deepOfArray][random(3) + 3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random(199) - 100;
            }
        }
        return array;
    }

    public static int sumOfPositiveElements(int[][] array) {
        System.out.println("В массиве: " + Arrays.deepToString(array));
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Сумма положительных элементов равна: " + sum);
        return sum;
    }

    public static void squareInConsole(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void diaonalsOfArray(int[][] array) {
        System.out.println("Начальный массив: " + Arrays.deepToString(array));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 0;
                }
                if (i + j == array.length) {
                    array[i][j] = 0;
                }
            }
        }
        System.out.println("Обновленный массив: " + Arrays.deepToString(array));
    }
    public static int findMax(int[][] array) {
        System.out.println("В массиве: " + Arrays.deepToString(array));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Максимальный элемент массива равен: " + max);
        return max;
    }

    public static int sumSecondElementsInArray(int[][] array) {
        if (array.length > 1) {
            int sum = 0;
            for (int i = 0; i < array[1].length; i++) {
                sum += array[1][i];
            }
            return sum;
        } else {
            return -1;
        }
    }
}