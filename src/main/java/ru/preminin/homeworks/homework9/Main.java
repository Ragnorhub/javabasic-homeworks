package ru.preminin.homeworks.homework9;

import ru.preminin.homeworks.homework9.enums.transport;
import ru.preminin.homeworks.homework9.human.Human;
import ru.preminin.homeworks.homework9.enums.terrain;

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
        human.info();
        human.takeATransport(transport.Horse);
        human.info();
        human.getOffTheTransport();
        human.doIt(2, terrain.Swamp);
        human.takeATransport(transport.Horse);
        human.doIt(2, terrain.Swamp);
        human.info();
        human.takeATransport(transport.Bicycle);
        human.doIt(20, terrain.Plain);
        human.info();
        human.doIt(2, terrain.Swamp);
        human.takeATransport(transport.Car);
        human.doIt(2, terrain.Swamp);
        human.doIt(2, terrain.DeepForest);
    }
}
