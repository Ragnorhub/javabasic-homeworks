package ru.preminin.homeworks.homework7;

import ru.preminin.homeworks.homework7.animal.*;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 3,2,15);
        Horse horse = new Horse("Star",10,3, 100);
        Dog dog = new Dog("Bobik",6, 2,50);
        horse.info();
        horse.swim(15);
        horse.info();
        horse.swim(3);
        dog.info();
        cat.swim(2);
    }
}
