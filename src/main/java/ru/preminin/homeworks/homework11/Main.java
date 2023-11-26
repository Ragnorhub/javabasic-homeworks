package ru.preminin.homeworks.homework11;

/*(Готово)Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
 *(Готово)Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
 *(Готово)Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать каждую заполненную ячейку списка указанным числом;
 *(Готово)Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число;
 *(Готово)Создайте класс Сотрудник с полями: имя, возраст;
 *(Готово)Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
 *(Готово)Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
 *(Готово)Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий что средний возраст сотрудников превышает указанный аргумент;
 *(Готово)Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Mathematics math = new Mathematics();
        System.out.println(math.rangeOfNumbers(1, 10));
        System.out.println(math.amountIfMoreThanFive(3, 7, 5, 8, -1));
        System.out.println(math.listOfASingleNumber(5, nums));
        System.out.println(math.increaseByNumber(4, nums));

        List<Employee> list = Arrays.asList(new Employee("Boris", 35),
                new Employee("Olga", 30),
                new Employee("Erzhan", 25),
                new Employee("Zuhra", 30));
        printNames(list);
        employeesByAge(list,30);
        employeesByMediumAge(list, 30);
        employeeMinAge(list);
    }

    private static void printNames(List<Employee> list) {
        for (Employee employee : list) {
            System.out.println(employee.getName());
        }
        System.out.println();
    }
    private static List<Employee> employeesByAge(List<Employee> list, int minAge) {
        List<Employee> newList = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= minAge) {
                newList.add(employee);
            }
        }
        System.out.println(newList + "\n");
        return newList;
    }

    private static boolean employeesByMediumAge(List<Employee> list, int mediumAge) {
        int sumEmployeeAge = 0;
        for (Employee employee : list) {
            sumEmployeeAge += employee.getAge();
        }
        if (sumEmployeeAge/list.size() >= mediumAge) {
            System.out.println("The average age of employees is greater than or equal to the entered value\n");
            return true;
        } else {
            System.out.println("The average age of employees is less than the entered value\n");
            return false;
        }
    }

    private static Employee employeeMinAge(List<Employee> list) {
        int indexMinAge = Integer.MAX_VALUE;
        int minAge = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            if (employee.getAge() < minAge) {
                minAge = employee.getAge();
                indexMinAge = i;
            }
        }
        System.out.println(list.get(indexMinAge));
        return list.get(indexMinAge);
    }

}





/*public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "AAA", "AAA", "AA", "AAAA", "A"));
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.length() > 2) {
                iter.remove();
            }
        }
        System.out.println(list);*/
/*    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(5);
        for (int i = 0; i < 10; i++) {
            values.add(5);
        }
        values.set(1,234);
        values.set(0,null);
        System.out.println(values);
        values.remove(0);
        System.out.println(values);
        values.get(0);
        values.add(3,23343455);
        values.remove(Integer.valueOf(234));
        System.out.println(values);
        values.remove(Integer.valueOf(5));
        System.out.println(values);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "AAA", "AA", "AAAA", "A"));
        Iterator<String> iter = list.iterator();
        for (String s : list) {
            if (s.length() > 2) {
                list.remove(s);
            }
        }
    }*/