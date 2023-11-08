package ru.preminin.homeworks.homework7.animal;

public abstract class Animal {
    protected String name;
    protected float velocity;
    protected float swimming;
    protected int endurance;
    protected int energyForRunning;
    protected int energyForSwimming;

    public void info() {
        System.out.println("Имя: " + name + "\nСкорость бега: " + velocity + "\nСкорость плавания: " + swimming +"\nВыносливость:"
                + endurance + "\n");
    }

    public float run(int distance) {
        if ((endurance - distance * energyForRunning) >= 0) {
            endurance -= distance*energyForRunning;
            System.out.println("Время затраченное на дистанцию " + distance + " метров составляет " + distance / velocity + " секунд\n");
        } else {
            System.out.println("У животного появилось состояние усталости\n");
            endurance = 0;
            return -1;
        }
        return distance / velocity;
    }

    public abstract float swim(int distance);
}
