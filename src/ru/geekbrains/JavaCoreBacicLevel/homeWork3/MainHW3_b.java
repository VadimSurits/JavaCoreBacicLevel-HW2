package ru.geekbrains.JavaCoreBacicLevel.homeWork3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainHW3_b {
    static Scanner scanner;
    static Random random;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();
        System.out.println("Привет! В этой игре загадано название фрукта или овоща на английском языке,\n" +
                "а тебе нужно его отгадать. Начинаем!");
        game();
    }

    public static void game() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String mainWord = words[random.nextInt(words.length)];
        String inputWord = null;
        do {
            System.out.println(Arrays.toString(words));
            // Не смог разобраться, как при "распечатывании" метода Arrays.toString() отформатировать массив строк
            // таким образом, чтобы элементы массива отображались в консоли упорядоченно, с нужной разбивкой
            // на нескольких строках, а не одной длинной строкой, выходящей за пределы консоли.
            System.out.println("Введи свой вариант: ");
            inputWord = (scanner.nextLine().toLowerCase());
            for (int i = 0; i < 15; i++) {
                if (i < mainWord.length() && i < inputWord.length() && mainWord.charAt(i) == inputWord.charAt(i)) {
                    System.out.print(mainWord.charAt(i));
                } else
                    System.out.print((mainWord.equals(inputWord)) ? "" : "#");
            }
            System.out.println();
        } while (!mainWord.equals(inputWord));
                System.out.println("Поздравляю! Ты угадал!");
    }
}