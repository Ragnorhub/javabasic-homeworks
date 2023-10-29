package ru.preminin.homeworks.tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final char FIRST_PLAYER = '╳';
    public static final char SECOND_PLAYER = '◯';
    public static final Random RANDOM = new Random();

    private static final char[][] MAP = createMap();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static char[][] createMap() {
        char[][] chars = new char[3][3];
        for (char[] aChars : chars) {
            Arrays.fill(aChars, ' ');
        }
        return chars;
    }

    public static void main(String[] args) {
        var isGameOver = false;
        printMap();
        while (!isGameOver) {
            playerOne();
            isGameOver = checkWinner(FIRST_PLAYER);
            printMap();
            if (isGameOver) {
                System.out.println("Первый игрок победил");
                return;
            }
            playerSecond();
            isGameOver = checkWinner(SECOND_PLAYER);
            printMap();
            if (isGameOver) {
                System.out.println("Компьютер победил");
                return;
            }
        }
    }

    private static boolean checkWinner(char ch) {
        return
                (MAP[0][0] == ch && MAP[0][1] == ch && MAP[0][2] == ch) ||
                        (MAP[1][0] == ch && MAP[1][1] == ch && MAP[1][2] == ch) ||
                        (MAP[2][0] == ch && MAP[2][1] == ch && MAP[2][2] == ch) ||

                        (MAP[0][0] == ch && MAP[1][0] == ch && MAP[2][0] == ch) ||
                        (MAP[0][1] == ch && MAP[1][1] == ch && MAP[2][1] == ch) ||
                        (MAP[0][2] == ch && MAP[1][2] == ch && MAP[2][2] == ch) ||

                        (MAP[0][0] == ch && MAP[1][1] == ch && MAP[2][2] == ch) ||
                        (MAP[2][0] == ch && MAP[1][1] == ch && MAP[0][2] == ch);
    }

    public static void playerOne() {
        var isNotDone = true;
        do {
            System.out.println("Введите координаты:");
            var x = SCANNER.nextInt() - 1;
            var y = SCANNER.nextInt() - 1;
            if (MAP[y][x] == ' ') {
                MAP[y][x] = FIRST_PLAYER;
                isNotDone = false;
            }
        } while (isNotDone);
    }

    public static void playerSecond() {
        var isNotDone = true;
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[i].length; j++) {
                if(MAP[i][j] == ' ') {
                    MAP[i][j] = FIRST_PLAYER;
                    boolean isWin = checkWinner(FIRST_PLAYER);
                    MAP[i][j] = ' ';
                    if (isWin) {
                        MAP[i][j] = SECOND_PLAYER;
                        return;
                    }
                }
            }
        }
        do {
            System.out.println("Ход компьютера");
            var x = RANDOM.nextInt(3);
            var y = RANDOM.nextInt(3);
            if (MAP[y][x] == ' ') {
                MAP[y][x] = SECOND_PLAYER;
                isNotDone = false;
            }
        } while (isNotDone);
    }

    private static void printMap() {
        System.out.print(RED + 0 + RESET + " ");
        for (int i = 1; i <= MAP.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP.length; i++) {
            System.out.print(i + 1 + "¦");
            for (char chars : MAP[i]) {
                System.out.print(chars + "¦");
            }
            System.out.println();
        }
    }
}