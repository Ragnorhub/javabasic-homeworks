package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.terrain;
import ru.preminin.homeworks.homework9.human.Human;

public class Car implements Transport {
    private int gasoline = 100;

    @Override
    public boolean move(int distance, terrain terrain) {
        if (terrain == terrain.SWAMP || terrain == terrain.DEEPFOREST) {
            System.out.println("The car will not pass through " + terrain + "\n");
            return false;
        }
        if (gasoline - distance / 3 >= 0) {
            gasoline -= distance / 3;
            System.out.println("The car drove " + distance + " km through " + terrain + "\n");
            return true;
        }
        System.out.println("Not enough gasoline");
        return false;
    }
}