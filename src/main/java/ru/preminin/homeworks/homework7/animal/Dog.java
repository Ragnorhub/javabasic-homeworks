package ru.preminin.homeworks.homework7.animal;

public class Dog extends Animal{

    public Dog(String name, float velocity, float swimming, int endurance) {
        this.name = name;
        this.velocity = velocity;
        this.swimming = swimming;
        this.endurance = endurance;
        this.energyForRunning = 1;
        this.energyForSwimming = 2;
    }
}
