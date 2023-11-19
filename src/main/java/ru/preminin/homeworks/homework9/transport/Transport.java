package ru.preminin.homeworks.homework9.transport;

import ru.preminin.homeworks.homework9.enums.Terrain;
import ru.preminin.homeworks.homework9.human.Human;

public interface Transport {
    boolean move(int distance, Terrain terrain);
    void setDriver(Human human);
}
