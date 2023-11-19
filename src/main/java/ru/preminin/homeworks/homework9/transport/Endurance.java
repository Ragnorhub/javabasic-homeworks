package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.terrain;
import ru.preminin.homeworks.homework9.human.Human;

public interface Endurance {
    boolean move(int distance, terrain terrain, Human human);
}
