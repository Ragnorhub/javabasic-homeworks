package ru.preminin.homeworks.homework8.cat;

import ru.preminin.homeworks.homework8.plate.Plate;

public class Cat {
    private final String name;
    boolean isSatiety;
    private final int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isSatiety = false;
    }

    public void eat(Plate plate) {
        if (!isSatiety) {
            System.out.println("Кот " + name + " начал кушать.");
            isSatiety = plate.decreaseFood(appetite);
        }
        if (isSatiety) {
            System.out.println("Кот " + name + " сытый.\n");
        }
    }
}
