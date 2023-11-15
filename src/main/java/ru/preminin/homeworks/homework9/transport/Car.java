package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.terrain;

public class Car implements Location {
    private int gasoline = 100;

    @Override
    public boolean run(int distance, terrain terrain) {
        if (terrain.equals(terrain.Swamp) || terrain.equals(terrain.DeepForest)) {
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