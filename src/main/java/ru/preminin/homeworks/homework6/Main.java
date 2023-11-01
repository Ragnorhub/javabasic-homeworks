package ru.preminin.homeworks.homework6;

public class Main {
    public static void main(String[] args) {
        User[] users = {
                new User("Кузнецов", "Артем", "Александрович", 1956, "sf@mail.ru"),
                new User("Попов", "Александр", "Иванович", 1965, "seffgs@mail.ru"),
                new User("Ковалев", "Иван", "Максимович", 1978, "hjlikft@mail.ru"),
                new User("Мельников", "Максим", "Дмитриевич", 1948, "sdftjk@mail.ru"),
                new User("Колесников", "Дмитрий", "Михайлович", 1989, "sdfgk@mail.ru"),
                new User("Пономарев", "Михаил", "Кириллович", 1998, "ukjsdf@mail.ru"),
                new User("Казаков", "Кирилл", "Матвеевич", 1965, "jkldsff@mail.ru"),
                new User("Смирнов", "Матвей", "Егорович", 2005, "wrjkll@mail.ru"),
                new User("Иванов", "Егор", "Ильич", 1957, "uiopxcv@mail.ru"),
                new User("Лебедев", "Илья", "Артемович", 1995, "zxvcuiop@mail.ru")
        };
        for (User user : users) {
            if ((2023 - user.getYearOfBirth()) > 40) {
                user.info();
            }
        }

        Box box = new Box(5,7,8,"Чёрный", true,true, "");
        box.info();
        box.setThingInBox("Стакан");
        box.setColor("Зелёный");
        box.info();
        box.switchBoxOpenClose();
        box.getThingFromBox();
        box.info();
        box.switchBoxOpenClose();
        box.getThingFromBox();
        box.info();
    }
}