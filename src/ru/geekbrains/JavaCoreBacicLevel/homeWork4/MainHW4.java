package ru.geekbrains.JavaCoreBacicLevel.homeWork4;

import java.util.Random;
import java.util.Scanner;

public class MainHW4 {   //Задание 1
    public static char[][] map;

    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_Y = 'Y';

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Ты победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_Y)) {
                System.out.println("Победил компьютер!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
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

    public static void humanTurn() {
        int x, y;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите координаты в формате X, Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        int x, y;
        Random rand = new Random();
        System.out.println("Ход компьютера:");
        do {
           x = rand.nextInt(SIZE);
           y = rand.nextInt(SIZE);
        } while (!isCellValid(y, x));
        if(checkBlockHuman() == false) {
            map[y][x] = DOT_Y;
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x > SIZE || y < 0 || y > SIZE) {
            return false;
        }
        return (map[x][y] == DOT_EMPTY);
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char c) {   //Задание 2 - Проверка победы для комбинации из 3 фишек
        for (int i = 0; i < SIZE - 2; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c && map[i + 1][j] == c && map[i + 2][j] == c) {
                    return true;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[i][j] == c && map[i][j + 1] == c && map[i][j + 2] == c) {
                    return true;
                }
            }
        }
        for (int i = 0; i < SIZE - 2; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if ((map[i][j] == c && map[i + 1][j + 1] == c && map[i + 2][j + 2] == c) ||
                        (map[i + 2][j] == c && map[i + 1][j + 1] == c && map[i][j + 2] == c)) {
                    return true;
                }
            }
        }
        return false;
    }

    //    Задание 3 - Проверка победы для комбинации из 4 фишек на поле 5х5
//    public static boolean checkWin(char c){
//        for (int i = 0; i < SIZE - 3; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][j] == c && map[i + 1][j] == c && map[i + 2][j] == c && map[i + 3][j] == c) {
//                    return true;
//                }
//            }
//        }
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE - 3; j++) {
//                if (map[i][j] == c && map[i][j + 1] == c && map[i][j + 2] == c && map[i][j + 3] == c) {
//                    return true;
//                }
//            }
//        }
//        for (int i = 0; i < SIZE - 3; i++) {
//            for (int j = 0; j < SIZE - 3; j++) {
//                if ((map[i][j] == c && map[i + 1][j + 1] == c && map[i + 2][j + 2] == c && map[i + 3][j + 3] == c) ||
//                        (map[i][j + 3] == c && map[i + 1][j + 2] == c && map[i + 2][j + 1] == c && map[i + 3][j] == c))
//                return true;
//                }
//            }
//        return false;
//    }

    public static boolean checkBlockHuman() {   //Задание 4 - Попытка блокировать победный ход игрока
        for (int i = 0; i < SIZE - 2; i++) {    //Корректно работает для выигрышной комбинации из 3 фишек
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X && map[i + 1][j] == DOT_X && map[i + 2][j] != DOT_Y) {
                    map[i + 2][j] = DOT_Y;
                    return true;
                }
                if (map[i][j] == DOT_X && map[i + 2][j] == DOT_X && map[i + 1][j] != DOT_Y) {
                    map[i + 1][j] = DOT_Y;
                    return true;
                }
                if (map[i + 1][j] == DOT_X && map[i + 2][j] == DOT_X && map[i][j] != DOT_Y) {
                    map[i][j] = DOT_Y;
                    return true;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[i][j] == DOT_X && map[i][j + 1] == DOT_X && map[i][j + 2] != DOT_Y) {
                    map[i][j + 2] = DOT_Y;
                    return true;
                }
                if (map[i][j] == DOT_X && map[i][j + 2] == DOT_X && map[i][j + 1] != DOT_Y) {
                    map[i][j + 1] = DOT_Y;
                    return true;
                }
                if (map[i][j + 1] == DOT_X && map[i][j + 2] == DOT_X && map[i][j] != DOT_Y) {
                    map[i][j] = DOT_Y;
                    return true;
                }
            }
        }
        for (int i = 0; i < SIZE - 2; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[i][j] == DOT_X && map[i + 1][j + 1] == DOT_X && map[i + 2][j + 2] != DOT_Y) {
                    map[i + 2][j + 2] = DOT_Y;
                    return true;
                }
                if (map[i][j] == DOT_X && map[i + 2][j + 2] == DOT_X && map[i + 1][j + 1] != DOT_Y) {
                    map[i + 1][j + 1] = DOT_Y;
                    return true;
                }
                if (map[i + 1][j + 1] == DOT_X && map[i + 2][j + 2] == DOT_X && map[i][j] != DOT_Y) {
                    map[i][j] = DOT_Y;
                    return true;
                }
                if (map[i + 2][j] == DOT_X && map[i + 1][j + 1] == DOT_X && map[i][j + 2] != DOT_Y) {
                    map[i][j + 2] = DOT_Y;
                    return true;
                }
                if (map[i + 2][j] == DOT_X && map[i][j + 2] == DOT_X && map[i + 1][j + 1] != DOT_Y ) {
                    map[i + 1][j + 1] = DOT_Y;
                    return true;
                }
                if (map[i][j +2] == DOT_X && map[i + 1][j + 1] == DOT_X && map[i + 2][j] != DOT_Y ) {
                    map[i + 2][j] = DOT_Y;
                    return true;
                }
            }
        }
        return false;
    }
}









