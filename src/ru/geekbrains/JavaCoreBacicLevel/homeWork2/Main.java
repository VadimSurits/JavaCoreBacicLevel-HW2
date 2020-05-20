package ru.geekbrains.JavaCoreBacicLevel.homeWork2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                arr1[i] = 0;
            } else if (arr1[i] == 0) {
                arr1[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr1)); // Задание 1


        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr2)); // Задание 2


        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3)); // Задание 3


        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j || i + j == arr4[i].length - 1) {
                    arr4[i][j] = 1;
                }
                System.out.printf("%s ", arr4[i][j]);
            }
            System.out.println(); // Задание 4
        }

        int[] arr5 = {1, 3, 9, 6, 15, 0, 5, 8, 12};
        int maxNumber = arr5[0];
        int minNumber = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > maxNumber) {
                maxNumber = arr5[i];
            }
            if (arr5[i] < minNumber) {
                minNumber = arr5[i];
            }
        }
        System.out.println("Максимальное число массива = " + maxNumber);
        System.out.println("Минимальное число массива = " + minNumber); // Задание 5


        int[] arr6 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(task6(arr6)); // проверка работоспособности метода из 6 задания

        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8};
        task7(arr7,2);
        task7(arr7, -3); // проверка работоспособности метода из 7 задания
    }

    public static boolean task6(int[] arr6) {
        int sumArray = 0;
        int counter = 0;
        for (int i = 0; i < arr6.length; i++) {
            sumArray += arr6[i];
        }
        int halfSum = sumArray / 2;
        for (int i = 0; i < arr6.length; i++) {
            counter += arr6[i];
            if (counter == halfSum) {
                break;
            }
        }
        return (counter == halfSum);
    } // Задание 6


    public static void task7(int[] arr7, int n) {
        if(n >= 0){
            for (int i = 0; i < (arr7.length - n) ; i++) {
                arr7[i] = i + n + 1;
            }
            for (int i = (arr7.length - n); i >= (arr7.length - n) && i < arr7.length; i++) {
                arr7[i] = ((i + 1) - (arr7.length - n));
            }
            System.out.println("Сдвиг позиций на " + n + " = " + Arrays.toString(arr7));
        }
        if(n < 0){
            for (int i = 0; (i <= arr7.length - (arr7.length + n) - 1); i++){
                arr7[i] = i + (arr7.length + n) + 1;
            }
            for (int i = arr7.length - (arr7.length + n); i >= arr7.length - (arr7.length + n) && i < arr7.length; i++){
                arr7[i] = i + n + 1;
            }
            System.out.println("Сдвиг позиций на " + n + " = " + Arrays.toString(arr7));
        } // Задание 7

    }
}

