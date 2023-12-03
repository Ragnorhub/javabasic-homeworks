package ru.preminin.homeworks.homework12;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    Map<Object, Object> phoneBook = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        phoneBook.put(name,phoneNumber);
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
}
