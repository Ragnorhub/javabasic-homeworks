package ru.preminin.homeworks.homework13;

import java.util.LinkedList;
import java.util.List;

/**
 * (Готово) Написать свой класс MyLinkedList поддерживающий методы
 * Написать функцию int[] sort(int[] array) - возвращающий отсортированный по возрастанию массив. Готовыми методами сортировки не пользоваться - использовать алгоритм сортировки пузырьком
 * ** В задании выше осуществить сортировку с помощью алгоритма quicksort или слиянием (сложность O(N log(N))
 **/

public class MyLinkedList {

    List<Object> linkedList = new LinkedList<>();

    /**
     * addFirst(T data) - добавляет элемент в начало списка, остальные сдвигаются вправо
     **/
    public void addFirst(Object data) {
        linkedList.add(0, data);
    }

    /**
     * addLast(T data) - добавляет элемент в конец списка
     **/
    public void addLast(Object data) {
        linkedList.add(linkedList.size(), data);
    }

    /**
     * T getFirst() - возвращает первый элемент списка
     **/
    public void getFirst() {
        System.out.println("First Element: " + linkedList.get(0));
    }

    /**
     * T getLast() - возвращает последний элемент списка
     **/
    public void getLast() {
        System.out.println("Last Element: " + linkedList.get(linkedList.size() - 1));
    }

    /**
     * add(int position, T data) - вставляет элемент на позицию с номером position, остальные элементы сдвигаются вправо
     **/
    public void add(int position, Object data) {
        linkedList.add(position - 1, data);
    }

    /**
     * T remove(int position) - удаляет элемент с номером position
     **/
    public void remove(int position) {
        linkedList.remove(position - 1);
    }

    /**
     * T get(int position) - возвращает элемент с номером position
     **/
    public void get(int position) {
        System.out.println("Element: " + linkedList.get(position-1));
    }

    /**
     * int getSize() - возвращает количество элементов в списке.
     **/
    public void getSize() {
        System.out.println("Size: " + linkedList.size());
    }

    @Override
    public String toString() {
        return "MyLinkedList: " + linkedList;
    }
}
