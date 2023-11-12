package ru.preminin.homeworks.homework8.cat;

import ru.preminin.homeworks.homework8.plate.Plate;

public class Cat {
    String name;
    boolean isSatiety;

    public Cat(String name) {
        this.name = name;
        this.isSatiety = false;
    }

    public void eat(Plate plate) {
        System.out.println("Кот " + name + " начал кушать.");
        isSatiety = plate.decreaseFoodToAPlate(26);
        if (isSatiety) {
            System.out.println("Кот " + name + " теперь сытый.\n");
        }
    }
}
