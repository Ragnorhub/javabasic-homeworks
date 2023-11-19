package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.Terrain;
import ru.preminin.homeworks.homework9.human.Human;

public class Legs{

    public boolean move(int distance, Terrain terrain, Human human) {
        if (human.getEndurance() - distance * 2 >= 0) {
            human.setEndurance(human.getEndurance() - distance * 2);
            System.out.println(human.getName() + " walked " + distance + " km through " + terrain + "\n");
            return true;
        }
        System.out.println(human.getName() + " doesn't have the stamina to pass\n");
        return false;
    }
}
