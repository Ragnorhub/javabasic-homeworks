package ru.preminin.homeworks.homework9.human;

import ru.preminin.homeworks.homework9.enums.Terrain;
import ru.preminin.homeworks.homework9.enums.Transport;
import ru.preminin.homeworks.homework9.transport.*;

public class Human{

    private final String name;
    private Transport currentTransport;
    private int endurance;

    public Human(String name) {
        this.name = name;
        this.currentTransport = Transport.LEGS;
        endurance = 100;
    }

    public String getName() {
        return name;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void info() {
        System.out.println("Name: " + name + "\nTransport: " + currentTransport + "\nEndurance: " + endurance + "\n");
    }

    public void takeATransport(Transport transport) {
        currentTransport = transport;
    }

    public void getOffTheTransport(Human human) {
        currentTransport = Transport.LEGS;
    }

    public String getCurrentTransport() {
        return String.valueOf(currentTransport);
    }
    Horse horse = new Horse();
    Bicycle bicycle = new Bicycle();
    Car car = new Car();
    Rover rover =new Rover();
    Legs legs = new Legs();
    public boolean move(int distance, Terrain terrain, Human human) {
        switch (human.getCurrentTransport()) {
            case "HORSE":
                car.setDriver(null);
                bicycle.setDriver(null);
                rover.setDriver(null);
                horse.setDriver(human);
                horse.move(distance, terrain);
                return true;
            case "BICYCLE":
                car.setDriver(null);
                horse.setDriver(null);
                rover.setDriver(null);
                bicycle.setDriver(human);
                bicycle.move(distance, terrain);
                return true;
            case "CAR":
                horse.setDriver(null);
                bicycle.setDriver(null);
                rover.setDriver(null);
                car.setDriver(human);
                car.move(distance, terrain);
                return true;
            case "ROVER":
                car.setDriver(null);
                bicycle.setDriver(null);
                horse.setDriver(null);
                rover.setDriver(human);
                rover.move(distance, terrain);
                return true;
            case "LEGS":
                legs.move(distance, terrain, human);
                return true;
        }
        return false;
    }
}