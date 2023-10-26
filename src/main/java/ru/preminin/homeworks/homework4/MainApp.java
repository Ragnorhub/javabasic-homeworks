package ru.preminin.homeworks.homework4;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        stringRepeater(5,"Hello");
        sumIfHigherThanFive(randomArray());
        System.out.println(Arrays.toString(arrayOfNumber(5, randomArray())));
        System.out.println(Arrays.toString(arrayOfMultiple(5, randomArray())));
        comparingArrayParts(randomArray());
        reverseArray(randomArray());
        isArraySorted(randomArray(), (random(5) > 2));
        arrayEqualiyPoint(randomArray());
        sumOfArrays(randomTwoDimensionsArray(3));
    }

    public static int random(int range) {
        return (int) (Math.random() * range);
    }

    public static int[] randomArray() {
        int[] array = new int[random(8) + 2];
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

    public static void sumIfHigherThanFive(int[] array) {
        int sum = 0;
        for (int num : array) {
            if (num > 5) {
                sum += num;
            }
        }
        System.out.println(sum);
    }

    public static int[] arrayOfNumber(int number, int[] array) {
        Arrays.fill(array, number);
        return array;
    }

    public static int[] arrayOfMultiple(int number, int[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] += number;
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

    public static void reverseArray(int[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void isArraySorted(int[] array, boolean isAscending) {
        System.out.println("Массив: " + Arrays.toString(array));
        if (array.length <= 1) {
            System.out.println("Массив состоит из одного элемента, или массив пустой");
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1] == isAscending) {
                System.out.println("Массив не прошел проверку на isAscending: " + isAscending);
                return;
            }
        }
        System.out.println("Массив прошел проверку на isAscending: " + isAscending);
    }

    public static void arrayEqualiyPoint(int[] arr) {
        System.out.println("Массив: " + Arrays.toString(arr));
        if (arr.length < 2) {
            System.out.println("В массиве недосаточно элементов для сравнения.");
            return;
        }
        int sumLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            int sumRight = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                System.out.println("В массиве присутствует точка равенства правой и левой части массива. " +
                        "Она находится между " + arr[i] + " и " + arr[i + 1]);
                return;
            }
        }
        System.out.println("В массиве отсутствует точка равенства правой и левой части массива.");
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

    public static int[] sumOfArrays(int[][] array) {
        System.out.println("Массивы для суммирования: " + Arrays.deepToString(array));
        int maxArrayLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length > maxArrayLength) {
                maxArrayLength = array[i].length;
            }
        }
        int[] newArray = new int[maxArrayLength];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newArray[j] += array[i][j];
            }
        }
        System.out.println("Суммирующий массив: " + Arrays.toString(newArray));
        return newArray;
    }
}