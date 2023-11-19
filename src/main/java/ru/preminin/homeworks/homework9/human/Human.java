package ru.preminin.homeworks.homework9.human;

import ru.preminin.homeworks.homework9.enums.transport;

public class Human{

    private final String name;
    private transport currentTransport;
    private int endurance;

    public Human(String name) {
        this.name = name;
        this.currentTransport = transport.LEGS;
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

    public void takeATransport(transport transport) {
        currentTransport = transport;
    }

    public void getOffTheTransport() {
        currentTransport = transport.LEGS;
    }
    public String getCurrentTransport() {
        return String.valueOf(currentTransport);
    }
}