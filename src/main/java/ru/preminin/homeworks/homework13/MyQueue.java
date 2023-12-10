package ru.preminin.homeworks.homework13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * На основе разработанного MyLinkedList создать класс MyQueue работающий по принципу очереди, и имеющий два метода
 * offer(T data), добавляющий элемент в очередь и T poll() - забирающий элемент из очереди
 */
public class MyQueue {
    Queue<Object> queue = new LinkedList<>();

    public void offer(Object data) {
        queue.offer(data);
    }

    public void poll() {
        queue.poll();
    }

    @Override
    public String toString() {
        return "MyQueue: "+ queue;
    }
}
