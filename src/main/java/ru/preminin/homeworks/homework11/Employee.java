package ru.preminin.homeworks.homework11;

public class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", age=" + age + "\n";
    }
}
