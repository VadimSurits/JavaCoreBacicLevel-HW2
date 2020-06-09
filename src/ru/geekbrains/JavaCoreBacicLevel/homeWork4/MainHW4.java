package ru.geekbrains.JavaCoreBacicLevel.homeWork4;

import java.util.Random;
import java.util.Scanner;

public class MainHW4 {   //Задание 1
    public static char[][] map;

    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWinLines(DOT_X)) {
                System.out.println("Ты победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWinLines(DOT_O)) {
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
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X, Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
//        int x, y;                            // Это был мой вариант
//        System.out.println("Ход компьютера:");
//        do {
//           x = rand.nextInt(SIZE);
//           y = rand.nextInt(SIZE);
//        } while (!isCellValid(y, x));
//        if(checkBlockHuman() == false) {
//            map[y][x] = DOT_Y;
//        }
//    }
        int x, y;
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE ; j++) {
                if(isCellValid(i, j)){
                    map[i][j] = DOT_O;
                }
                if(checkWinLines(DOT_O)){
                    return;
                }
                map[i][j] = DOT_EMPTY;
            }
        }
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        do{
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }


    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
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
        for (int i = 0; i < SIZE - 2; i++) {   // Мое решение
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


    static boolean checkWinLines(char dot){   //Решение преподавателя
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE ; j++) {
                if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) ||
                        checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)){
                    return true;
                }
            }
        }
        return false;
    }



    public static boolean checkLine(int cy, int cx, int vy, int vx, char dot){  //Решение преподавателя
        if(cx + vx * (DOTS_TO_WIN - 1) > SIZE - 1 || cy + vy * (DOTS_TO_WIN - 1) > SIZE - 1 ||
        cy + vy * (DOTS_TO_WIN - 1) < 0 ){
            return false;
        }
        for (int i = 0; i < DOTS_TO_WIN ; i++) {
            if(map[cy + i * vy][cx + i * vx] != dot){
                return false;
            }
        }
        return true;
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
                                                // Мой вариант решения
    public static boolean checkBlockHuman() {   //Задание 4 - Попытка блокировать победный ход игрока
        for (int i = 0; i < SIZE - 2; i++) {    //Корректно работает для выигрышной комбинации из 3 фишек
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X && map[i + 1][j] == DOT_X && map[i + 2][j] != DOT_O) {
                    map[i + 2][j] = DOT_O;
                    return true;
                }
                if (map[i][j] == DOT_X && map[i + 2][j] == DOT_X && map[i + 1][j] != DOT_O) {
                    map[i + 1][j] = DOT_O;
                    return true;
                }
                if (map[i + 1][j] == DOT_X && map[i + 2][j] == DOT_X && map[i][j] != DOT_O) {
                    map[i][j] = DOT_O;
                    return true;
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[i][j] == DOT_X && map[i][j + 1] == DOT_X && map[i][j + 2] != DOT_O) {
                    map[i][j + 2] = DOT_O;
                    return true;
                }
                if (map[i][j] == DOT_X && map[i][j + 2] == DOT_X && map[i][j + 1] != DOT_O) {
                    map[i][j + 1] = DOT_O;
                    return true;
                }
                if (map[i][j + 1] == DOT_X && map[i][j + 2] == DOT_X && map[i][j] != DOT_O) {
                    map[i][j] = DOT_O;
                    return true;
                }
            }
        }
        for (int i = 0; i < SIZE - 2; i++) {
            for (int j = 0; j < SIZE - 2; j++) {
                if (map[i][j] == DOT_X && map[i + 1][j + 1] == DOT_X && map[i + 2][j + 2] != DOT_O) {
                    map[i + 2][j + 2] = DOT_O;
                    return true;
                }
                if (map[i][j] == DOT_X && map[i + 2][j + 2] == DOT_X && map[i + 1][j + 1] != DOT_O) {
                    map[i + 1][j + 1] = DOT_O;
                    return true;
                }
                if (map[i + 1][j + 1] == DOT_X && map[i + 2][j + 2] == DOT_X && map[i][j] != DOT_O) {
                    map[i][j] = DOT_O;
                    return true;
                }
                if (map[i + 2][j] == DOT_X && map[i + 1][j + 1] == DOT_X && map[i][j + 2] != DOT_O) {
                    map[i][j + 2] = DOT_O;
                    return true;
                }
                if (map[i + 2][j] == DOT_X && map[i][j + 2] == DOT_X && map[i + 1][j + 1] != DOT_O) {
                    map[i + 1][j + 1] = DOT_O;
                    return true;
                }
                if (map[i][j +2] == DOT_X && map[i + 1][j + 1] == DOT_X && map[i + 2][j] != DOT_O) {
                    map[i + 2][j] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }
}









