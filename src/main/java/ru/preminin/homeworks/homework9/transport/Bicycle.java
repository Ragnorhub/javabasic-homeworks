package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.Terrain;
import ru.preminin.homeworks.homework9.human.Human;

public class Bicycle implements Transport {
    Human driver;
    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == terrain.SWAMP) {
            System.out.println("The bicycle will not pass through the swamp\n");
            return false;
        }
        if (driver.getEndurance() - distance >= 0) {
            driver.setEndurance(driver.getEndurance() - distance);
            System.out.println("The bicycle drove " + distance + " km through " + terrain + "\n");
            return true;
        }
        System.out.println("Not enough stamina to drive");
        return false;
    }
    public void setDriver(Human human) {
        this.driver = human;
    }
}
