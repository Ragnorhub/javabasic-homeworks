package ru.preminin.homeworks.homework9.human;

import ru.preminin.homeworks.homework9.enums.terrain;
import ru.preminin.homeworks.homework9.enums.transport;
import ru.preminin.homeworks.homework9.transport.*;

public class Human implements Location {
    private final String name;
    private String currentTransport;
    private static int endurance;

    public static int getEndurance() {
        return endurance;
    }

    public static void setEndurance(int endurance) {
        Human.endurance = endurance;
    }

    public Human(String name) {
        this.name = name;
        this.currentTransport = "none";
        endurance = 100;
    }

    public void info() {
        System.out.println("Name: " + name + "\nTransport: " + currentTransport + "\nEndurance: " + endurance + "\n");
    }

    public void takeATransport(transport transport) {
        currentTransport = String.valueOf(transport);
    }

    public void getOffTheTransport() {
        currentTransport = "none";
    }

    @Override
    public boolean run(int distance, terrain terrain) {
        if (endurance - distance * 2 >= 0) {
            endurance -= distance * 2;
            System.out.println(name + " walked " + distance + " km through" + terrain + "\n");
            return true;
        }
        System.out.println(name + " doesn't have the stamina to pass\n");
        return false;
    }
    public boolean doIt(int distance, terrain terrain) {
        switch (currentTransport) {
            case "Horse":
                new Horse().run(distance, terrain);
                return true;
            case "Bicycle":
                new Bicycle().run(distance, terrain);
                return true;
            case "Car":
                new Car().run(distance, terrain);
                return true;
            case "Rover":
                new Rover().run(distance, terrain);
                return true;
            case "none":
                run(distance, terrain);
                return true;
        }
        return false;
    }
}
