package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.terrain;
import ru.preminin.homeworks.homework9.human.Human;

public class Bicycle implements Endurance {
    @Override
    public boolean move(int distance, terrain terrain, Human human) {
        if (terrain == terrain.SWAMP) {
            System.out.println("The bicycle will not pass through the swamp\n");
            return false;
        }
        if (human.getEndurance() - distance >= 0) {
            human.setEndurance(human.getEndurance() - distance);
            System.out.println("The bicycle drove " + distance + " km through " + terrain + "\n");
            return true;
        }
        System.out.println("Not enough stamina to drive");
        return false;
    }
}
