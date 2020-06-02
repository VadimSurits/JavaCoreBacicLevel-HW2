package ru.geekbrains.JavaCoreBacicLevel.homeWork6;

public class Animal {
    String name;
    String color;
    int age;
    static int animalNumber; //подсчет животных из 4 задания

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        animalNumber++;
    }

    public void run(int distance){
    System.out.println(name + " " + color + " " + age + " ran " + distance + " metres");
    }

    public void swim(int distance){
    System.out.println(name + " " + color + " " + age + " swam " + distance + " metres");
    }
}
