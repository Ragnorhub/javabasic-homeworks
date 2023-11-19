package ru.preminin.homeworks.homework9;

import ru.preminin.homeworks.homework9.enums.Terrain;
import ru.preminin.homeworks.homework9.enums.Transport;
import ru.preminin.homeworks.homework9.human.Human;
import ru.preminin.homeworks.homework9.transport.*;

/**
 * Описание/Пошаговая инструкция выполнения домашнего задания:
 * (Готово) Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
 * (Готово) Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
 * (Готово) Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
 * (Готово) В приложении должны быть типы местности: густой лес, равнина, болото
 * (Готово) Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него, или переместиться на некоторое расстояние (при условии что он находится на каком-либо транспорте)
 * (Готово) При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто идет указанное расстояние пешком
 * (Готово) При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силы. Велосипед может использоваться без ограничений (можете для усложнения велосипедом тратить силы “водителя”). При выполнении действия результат должен быть отпечатан в консоль
 * (Готово) У каждого вида транспорта есть местности по которым он не может перемещаться: машина - густой лес и болото, лошадь и велосипед - болото, вездеход - нет ограничений
 * (Готово) При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
 */


public class Main {
    public static void main(String[] args) {
        Human human = new Human("Shepard");

        System.out.println(human.getCurrentTransport());
        human.info();
        human.takeATransport(Transport.HORSE);
        human.info();
        run(6, Terrain.SWAMP, human);
        human.getOffTheTransport();
        human.info();
        run(400, Terrain.DEEPFOREST, human);
        run(48, Terrain.DEEPFOREST, human);
        human.info();
        human.takeATransport(Transport.BICYCLE);
        run(4, Terrain.PLAIN, human);
        human.info();
    }

    public static boolean run(int distance, Terrain terrain, Human human) {
        switch (human.getCurrentTransport()) {
            case "HORSE":
                Horse horse = new Horse();
                horse.setDriver(human);
                horse.move(distance, terrain);
                return true;
            case "BICYCLE":
                Bicycle bicycle = new Bicycle();
                bicycle.setDriver(human);
                bicycle.move(distance, terrain);
                return true;
            case "CAR":
                Car car = new Car();
                car.setDriver(human);
                car.move(distance, terrain);
                return true;
            case "ROVER":
                Rover rover =new Rover();
                rover.setDriver(human);
                rover.move(distance, terrain);
                return true;
            case "LEGS":
                Legs legs = new Legs();
                legs.move(distance, terrain, human);
                return true;
        }
        return false;
    }













    /*Human human = new Human("Shepard");
    Horse horse = new Horse();
        human.info();
        human.takeATransport(Transport.HORSE);
        human.info();
        human.getOffTheTransport();
        human.doIt(2, Terrain.SWAMP);
        human.takeATransport(Transport.HORSE);
        human.doIt(2, Terrain.SWAMP);
        human.info();
        human.takeATransport(Transport.BICICLE);
        human.doIt(20, Terrain.PLAIN);
        human.info();
        human.doIt(2, Terrain.SWAMP);
        human.takeATransport(Transport.CAR);
    run(2, Terrain.SWAMP);
        human.doIt(2, Terrain.DEEPFOREST);*/


}
