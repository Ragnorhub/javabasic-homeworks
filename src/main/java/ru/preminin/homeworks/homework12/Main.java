package ru.preminin.homeworks.homework12;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Nata", "+74953530292");
        System.out.println(phoneBook);
        phoneBook.addContact("Vlad", "+74953579754");
        phoneBook.addContact("Vlad", "+74953574542");
        System.out.println(phoneBook);

    }
}
