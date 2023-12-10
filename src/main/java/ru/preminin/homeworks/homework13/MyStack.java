package ru.preminin.homeworks.homework13;

import java.util.Stack;

/**
 * На основе разработанного MyLinkedList построить класс MyStack имеющий два метода - push(T data) - помещающий элемент в стек и T pop() - достающий элемент из стека
 **/

public class MyStack {
    Stack<Object> stack = new Stack<>();

    public void push(Object data) {
        stack.push(data);
    }
    public void pop() {
        stack.pop();
    }

    @Override
    public String toString() {
        return "MyStack: " + stack;
    }
}
