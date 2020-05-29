package ru.geekbrains.JavaCoreBacicLevel.homeWork5;

public class Sotrudnik {  //Задание 1
    String name;
    String position;
    String email;
    int phoneNumber;
    int salary;
    int age;

    public Sotrudnik(String name, String position, String email, int phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;         // Задание 2
    }

    public void printInfo(){    // Задание 3
        System.out.println(name + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age + " ");
    }
}
