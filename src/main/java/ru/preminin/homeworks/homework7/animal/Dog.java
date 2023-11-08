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
    @Override
    public float swim(int distance) {
        if ((endurance - distance * energyForSwimming) > 0) {
            endurance -= distance*energyForSwimming;
            System.out.println("Время затраченное на дистанцию " + distance + " составляет " + distance / velocity + " секунд\n");
        } else {
            System.out.println("У животного появилось состояние усталости\n");
            endurance = 0;
            return -1;
        }
        return distance / velocity;
    }
}
