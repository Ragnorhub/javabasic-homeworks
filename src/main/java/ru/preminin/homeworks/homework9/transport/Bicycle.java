package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.terrain;
import ru.preminin.homeworks.homework9.human.Human;

public class Bicycle implements Location {
    @Override
    public boolean run(int distance, terrain terrain) {
        if (terrain.equals(terrain.Swamp)) {
            System.out.println("The bicycle will not pass through the swamp\n");
            return false;
        }
        if (Human.getEndurance() - distance >= 0) {
            Human.setEndurance(Human.getEndurance() - distance);
            System.out.println("The bicycle drove " + distance + " km through " + terrain + "\n");
            return true;
        }
        System.out.println("Not enough stamina to drive");
        return false;
    }
}
