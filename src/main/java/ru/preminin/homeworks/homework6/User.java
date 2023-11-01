package ru.preminin.homeworks.homework6;

public class User {
    private String family;
    private String name;
    private String middleName;
    private int yearOfBirth;
    private String email;

    public User(String family, String name, String middleName, int yearOfBirth, String email) {
        this.family = family;
        this.name = name;
        this.middleName = middleName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void info() {
        System.out.println("ФИО: " + family + " " + name + " " + middleName);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("e-mail: " + email);
        System.out.println();
    }
}