package ru.preminin.homeworks.homework11;

import java.util.ArrayList;
import java.util.List;

public class Mathematics {
    public List<Integer> rangeOfNumbers(int min, int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public int amountIfMoreThanFive(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number > 5) {
                sum += number;
            }
        }
        return sum;
    }

    public List<Integer> listOfASingleNumber(int number, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != number) {
                list.set(i , number);
            }
        }
        return list;
    }
    public List<Integer> increaseByNumber(int number, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + number);
        }
        return list;
    }
}