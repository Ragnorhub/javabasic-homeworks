package ru.preminin.homeworks.homework10;


public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "2", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arr1 = {
                {"1", "2", "3", "4", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "2", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arr2 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "gh", "4"},
                {"1", "2", "3", "4"}
        };
        verifyArray(arr);
        verifyArray(arr1);
        verifyArray(arr2);
    }
public static void verifyArray(String[][] arr) {
    try {
        System.out.println(sumOfArrayElements(arr));
    } catch (AppArrayDataException | AppArraySizeException ex) {
        System.err.println(ex);
    }
}
    private static int sumOfArrayElements(String[][] arr) {
        int sum = 0;
        for (String[] strings : arr) {
            if (arr.length != 4 || strings.length != 4) {
                throw new AppArraySizeException("Wrong length of array. Must be 4*4");
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (char c: arr[i][j].toCharArray()) {
                    if (!Character.isDigit(c)) {
                        throw new AppArrayDataException("String in array " + i + " " + j);
                    }
                }
                sum += Integer.parseInt(arr[i][j]);
            }
        }
        return sum;
    }
}
