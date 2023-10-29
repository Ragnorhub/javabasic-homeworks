package ru.preminin.homeworks.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class GameApplication {
    static final int SIZE = 3;

    static final char EMPTY_SYMBOL = '*';
    static final char X_SYMBOL = 'X';
    static final char O_SYMBOL = 'O';

    static Scanner scanner = new Scanner(System.in);
    static char[][] map;
    static char humanSymbol, aiSymbol;

    public static void main(String[] args) {
        System.out.println("Game settings. Choose what to walk with: 1 - Х, 2 - О");
        int answer = scanner.nextInt();
        if (answer == 2) {
            humanSymbol = O_SYMBOL;
            aiSymbol = X_SYMBOL;
        } else {
            humanSymbol = X_SYMBOL;
            aiSymbol = O_SYMBOL;
        }
        initMap();
        printMap();
        System.out.println("Start game");
        while (true) {
            playerTurn();
            printMap();
            if (checkWin(humanSymbol)) {
                System.out.println("Player win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Drawn game");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(aiSymbol)) {
                System.out.println("AI win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Drawn game");
                break;
            }
        }
        System.out.println("Game over");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (char[] chars : map) {
            Arrays.fill(chars, EMPTY_SYMBOL);
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Player turn. Set coordinates (x, y)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isTheCellValid(x, y));
        map[y][x] = humanSymbol;
    }

    public static boolean isTheCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return true;
        }
        return map[y][x] != EMPTY_SYMBOL;
    }

    public static void aiTurn() {
        int x, y;
        int[] bestCells;
        bestCells = aiFindBestCells(aiSymbol);
        x = bestCells[0];
        y = bestCells[1];
        if (x == -1 && y == -1) {
            int[] cellToBlock = aiFindBestCells(humanSymbol);
            x = cellToBlock[0];
            y = cellToBlock[1];
        }
        if (x == -1 && y == -1) {
            do {
                x = (int) (Math.random() * SIZE);
                y = (int) (Math.random() * SIZE);
            } while (isTheCellValid(x, y));
        }
        System.out.println("AI turn: " + (x + 1) + " " + (y + 1));
        map[y][x] = aiSymbol;
    }

    public static int[] aiFindBestCells(char targetSymbol) {
        int[] out = new int[]{-1, -1};
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_SYMBOL) {
                    map[i][j] = targetSymbol;
                    if (checkWin(targetSymbol)) {
                        out = new int[]{j, i};
                    }
                    map[i][j] = EMPTY_SYMBOL;
                    if (out[0] > -1) {
                        return out;
                    }
                }
            }
        }
        return out;
    }

    public static boolean checkWin(char symbol) {
        if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) return true;
        if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) return true;
        if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) return true;

        if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) return true;
        if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) return true;
        if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) return true;

        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) return true;
        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) return true;

        return false;
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_SYMBOL) {
                    return false;
                }
            }
        }
        return true;
    }
}