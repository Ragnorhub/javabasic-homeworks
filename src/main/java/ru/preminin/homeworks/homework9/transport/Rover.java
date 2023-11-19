package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.Terrain;
import ru.preminin.homeworks.homework9.human.Human;

public class Rover implements Transport {
    Human driver;
    private int gasoline = 100;

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (gasoline - distance / 4 >= 0) {
            gasoline -= distance / 4;
            System.out.println("The rover drove " + distance + " km through " + terrain + "\n");
            return true;
        }
        System.out.println("Not enough gasoline");
        return false;
    }

    @Override
    public void setDriver(Human human) {
        driver = human;
    }
}
