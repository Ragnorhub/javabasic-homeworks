package ru.preminin.homeworks.homework12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
 * Метод add() должен позволять добавлять запись имя-телефон;
 * Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
 * Под одним именем может быть несколько телефонов (в случае однофамильцев, или наличии у одного человека нескольких номеров), тогда при запросе такой фамилии должны выводиться все телефоны;
 * Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
 **/

public class PhoneBook {
    Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public void add(String name, String phoneNumber) {
        ArrayList<String> phones = phoneBook.get(name);
        if (phones != null) {
            phones.add(phoneNumber);
        } else {
            phones = new ArrayList<>();
            phones.add(phoneNumber);
            phoneBook.put(name, phones);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "PhoneBook=" + phoneBook +
                '}';
    }

    public void find(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println(phoneBook.get(name));
        } else {
            System.out.println("The contact is missing from the list");
        }
    }

    public void containsPhoneNumber(String phone) {
        for (var phones : phoneBook.entrySet()) {
            for (int i = 0; i < phones.getValue().size(); i++) {
                if (phone.equals(phones.getValue().get(i))) {
                    System.out.println("The phone is present in the database");
                    return;
                }
            }
        }
        System.out.println("The phone is missing from the database");
    }

}