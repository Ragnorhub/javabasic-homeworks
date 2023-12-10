package ru.preminin.homeworks.homework13;

import java.util.Arrays;
import java.util.Random;

/**
 * Написать функцию int[] sort(int[] array) - возвращающий отсортированный по возрастанию массив. Готовыми методами сортировки не пользоваться - использовать алгоритм сортировки пузырьком
 * ** В задании выше осуществить сортировку с помощью алгоритма quicksort или слиянием (сложность O(N log(N))
 **/

public class Main {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();

        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            myList.addFirst(rnd.nextInt(10));
        }

        System.out.println(myList);
        myList.addFirst(11);
        System.out.println(myList);
        myList.addLast(15);
        System.out.println(myList);
        myList.getFirst();
        myList.getLast();
        myList.add(2, 4);
        System.out.println(myList);
        myList.remove(2);
        System.out.println(myList);
        myList.get(1);
        myList.getSize();

        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 4; i++) {
            myQueue.offer(rnd.nextInt(10));
        }

        System.out.println(myQueue);
        myQueue.poll();
        System.out.println(myQueue);

        MyStack myStack = new MyStack();
        for (int i = 0; i < 4; i++) {
            myStack.push(rnd.nextInt(10));
        }
        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(100)-50;
        }
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

        // * В задании выше осуществить сортировку с помощью алгоритма quicksort или слиянием (сложность O(N log(N))
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(100) - 50;
        }
        System.out.println("Unsorted Array: " + Arrays.toString(array));
        QuickSort.quickSort(array, 0 , array.length - 1);
        System.out.println("  Sorted Array: " + Arrays.toString(array));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean changed = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int num = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = num;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }
}
