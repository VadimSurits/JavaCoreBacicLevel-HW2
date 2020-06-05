package ru.geekbrains.JavaCoreBacicLevel.homeWork7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean foodDecrease(int eaten) {
        if ((food - eaten) >= 0) {       // Задание 2
            food -= eaten;
            return true;
        } else{
            return false;
        }
    }

    public void foodIncrease(int addedFood){  // Метод для добавления еды в тарелку (задание 6)
        food += addedFood;
    }

    public void info () {
        System.out.println("Food left: " + food);
    }
}