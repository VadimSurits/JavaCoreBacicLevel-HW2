package ru.geekbrains.JavaCoreBacicLevel.homeWork6;

public class Cat extends Animal {
    static int catsNumber;

    public Cat(String name, String color, int age) {
        super(name, color, age);
        catsNumber++;// подсчет кошек из 4 задания
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Cat " + name + " (" + color + " color, " + age + " years old) ran its runLimit "
                    + "200 metres and tyred");
        } else {
            System.out.println("Cat " + name + " (" + color + " color, " + age + " years old) ran " + distance +
                    " metres");
        }
    }

    @Override
    public void swim(int distance){
        System.out.println("Cat " + name + " (" + color + " color, " + age + " years old) didn't swim, " +
                "because cats cannot swim");
    }
}
