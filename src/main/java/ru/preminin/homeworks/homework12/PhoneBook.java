package ru.preminin.homeworks.homework12;

import java.util.*;

/**
 * Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
 * Метод add() должен позволять добавлять запись имя-телефон;
 * Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
 * Под одним именем может быть несколько телефонов (в случае однофамильцев, или наличии у одного человека нескольких номеров), тогда при запросе такой фамилии должны выводиться все телефоны;
 * Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
 **/

public class PhoneBook {
    private Map<Object, List<String>> phoneBook = new HashMap<>();

    protected void add(String name, String phoneNumber) {
        List<String> phones = phoneBook.get(name);
        if (phones != null) {
            phones.add(phoneNumber);
        } else {
            phones = new ArrayList<>();
            phones.add(phoneNumber);
            phoneBook.put(name, phones);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "PhoneBook: " + phoneBook;
    }

    public Object find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return "The contact is missing from the list";
    }

    public void containsPhoneNumber(String phone) {
        for (var phones : phoneBook.entrySet()) {
            if (phones.getValue().contains(phone) ) {
                System.out.println("The phone is present in the database");
                return;
            }
        }
        System.out.println("The phone is missing from the database");
    }
}