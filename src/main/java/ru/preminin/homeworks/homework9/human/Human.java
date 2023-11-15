package ru.preminin.homeworks.homework9.human;

public class Human {
    private String name;
    private String currentTransport;
    private int endurance;

    public Human(String name) {
        this.name = name;
        this.currentTransport = "none";
        this.endurance = 100;
    }

    public void info() {
        System.out.println("Name: " + name + "\nTransport: " + currentTransport + "\nEndurance: " + endurance + "\n");
    }

}
