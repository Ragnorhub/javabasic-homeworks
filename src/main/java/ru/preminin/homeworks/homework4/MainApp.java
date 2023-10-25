package ru.preminin.homeworks.homework4;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        stringRepeater(5,"Hello");
        System.out.println(Arrays.toString(randomArray()));
        sumIfFive(randomArray());
        System.out.println(Arrays.toString(arrayOfNumber(5, randomArray())));
        System.out.println(Arrays.toString(arrayOfMultiple(5, randomArray())));
        comparingArrayParts(randomArray());
        reverseArray(randomArray());
        arrayIsSorted(randomArray(), (random(5) > 2));
        arrayEqualiyPoint(randomArray());
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

    public static void arrayIsSorted(int[] array, boolean isAscending) {
        System.out.println("Массив: " + Arrays.toString(array));
        if (array.length <= 1) {
            System.out.println("Массив состоит из одного элемента, или массив пустой");
            return;
        }
        if (isAscending) {
            int counter = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] >= array[i + 1]) {
                    System.out.println("Массив не восходящий.");
                    break;
                }
                counter++;
                if (counter == array.length - 1) {
                    System.out.println("Массив восходящий");
                }
            }
        } else {
            int counter = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] <= array[i + 1]) {
                    System.out.println("Массив не нисходящий");
                    break;
                }
                counter++;
                if (counter == array.length - 1) {
                    System.out.println("Массив нисходящий");
                }
            }
        }
    }

    public static void arrayEqualiyPoint(int[] arr) {
        int counter = 0;
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
                break;
            }
            counter++;
        }
        if (counter == arr.length) {
            System.out.println("В массиве отсутствует точка равенства правой и левой части массива.");
        }
    }
}

