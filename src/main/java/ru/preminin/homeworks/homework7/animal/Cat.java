package ru.preminin.homeworks.homework7.animal;

public class Cat extends Animal{

    public Cat(String name, float velocity, float swimming, int endurance) {
        this.name = name;
        this.velocity = velocity;
        this.swimming = swimming;
        this.endurance = endurance;
        this.energyForRunning = 1;
        this.energyForSwimming = 0;
    }
    @Override
    public float swim(int distance) {
            System.out.println("Коты не умеют плавать\n");
            return -1;
    }
}
