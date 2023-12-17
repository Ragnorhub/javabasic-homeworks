package ru.preminin.homeworks.homework12;

/**
 * Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
 * Метод add() должен позволять добавлять запись имя-телефон;
 * Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
 * Под одним именем может быть несколько телефонов (в случае однофамильцев, или наличии у одного человека нескольких номеров), тогда при запросе такой фамилии должны выводиться все телефоны;
 * Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
 **/

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nata", "+74953530292");
        System.out.println(phoneBook);
        phoneBook.add("Vlad", "+74953579754");
        phoneBook.add("Vlad", "+74953574542");
        System.out.println(phoneBook);
        System.out.println(phoneBook.find("Nata"));
        System.out.println(phoneBook.find("Vlad"));
        System.out.println(phoneBook.find("Drtg"));
        phoneBook.containsPhoneNumber("+74953579754");
    }
}