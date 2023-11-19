package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.terrain;
import ru.preminin.homeworks.homework9.human.Human;

public class Horse implements Transport {
    private int endurance = 100;

    @Override
    public boolean move(int distance, terrain terrain) {
        if (terrain == terrain.SWAMP) {
            System.out.println("The horse does not walk in the " + terrain + "\n");
            return false;
        }
        if (endurance - distance >= 0) {
            endurance -= distance;
            System.out.println("The HORSE walked " + distance + " km through " + terrain + "\n");
            return true;
        }
        System.out.println("The horse will not have enough stamina\n");
        return false;
    }
}
