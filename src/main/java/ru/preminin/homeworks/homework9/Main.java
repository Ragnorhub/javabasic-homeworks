package ru.preminin.homeworks.homework9;

import ru.preminin.homeworks.homework9.enums.transport;
import ru.preminin.homeworks.homework9.human.Human;
import ru.preminin.homeworks.homework9.enums.terrain;
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
        human.takeATransport(transport.HORSE);
        human.info();
        run(6, terrain.SWAMP, human);
        human.getOffTheTransport();
        human.info();
        run(400, terrain.DEEPFOREST, human);
        run(48, terrain.DEEPFOREST, human);
        human.info();
        human.takeATransport(transport.BICYCLE);
        run(4, terrain.DEEPFOREST, human);
        human.info();
    }

    public static boolean run(int distance, terrain terrain, Human human) {
        switch (human.getCurrentTransport()) {
            case "HORSE":
                new Horse().move(distance, terrain);
                return true;
            case "BICYCLE":
                new Bicycle().move(distance, terrain, human);
                return true;
            case "CAR":
                new Car().move(distance, terrain);
                return true;
            case "ROVER":
                new Rover().move(distance, terrain);
                return true;
            case "LEGS":
                new Legs().move(distance, terrain, human);
                return true;
        }
        return false;
    }













    /*Human human = new Human("Shepard");
    Horse horse = new Horse();
        human.info();
        human.takeATransport(transport.HORSE);
        human.info();
        human.getOffTheTransport();
        human.doIt(2, terrain.SWAMP);
        human.takeATransport(transport.HORSE);
        human.doIt(2, terrain.SWAMP);
        human.info();
        human.takeATransport(transport.BICICLE);
        human.doIt(20, terrain.PLAIN);
        human.info();
        human.doIt(2, terrain.SWAMP);
        human.takeATransport(transport.CAR);
    run(2, terrain.SWAMP);
        human.doIt(2, terrain.DEEPFOREST);*/


}
