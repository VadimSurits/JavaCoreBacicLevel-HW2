package ru.geekbrains.JavaCoreBacicLevel.homeWork3;

import java.util.Random;
import java.util.Scanner;

public class MainHW3_a {
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();
        System.out.println("Привет! Это игра 'Угадай число'!");
        guessTheNumber();
    }

    public static void guessTheNumber(){
        int number = random.nextInt (10)+0;
        int counter = 3;
        while (true) {
            System.out.println("Начинаем! Попыток для угадывания: " + counter + ".\nВведи число от 0 до 9");
            int inputNumber = scanner.nextInt();
            if (inputNumber == number) {
                System.out.println("Поздравляю! Ты угадал!");
                break;
            } else if (inputNumber > number && counter > 1) {
                counter--;
                System.out.println("Загаданное число меньше, чем " + inputNumber);
            } else if (inputNumber < number && counter > 1) {
                counter--;
                System.out.println("Загаданное число больше, чем " + inputNumber);
            } else {
                System.out.println("К сожалению, ты не угадал!\nБыло загадано число: " + number);
                break;
            }
        }
        gameRepeat();
    }

    public static void gameRepeat() {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int quit = scanner.nextInt();
        if (quit == 1) {
            guessTheNumber();
        } else if (quit != 1 && quit != 0) {
            gameRepeat();
        } else {
            System.out.println("Спасибо за игру! Удачи!");
        }
    }
}
