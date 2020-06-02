package ru.geekbrains.JavaCoreBacicLevel.homeWork6;

public class MainHW6 {
    public static void main(String[] args) {
    Animal Cat1 = new Cat("Barsik", "grey", 5);
    Animal Cat2 = new Cat("Murzik", "black", 9);
    Animal Dog1 = new Dog("Sharik", "white", 3, 600, 50);
    Animal Dog2 = new Dog("Bobik", "black", 2, 400, 10);

    Dog1.swim(150);
    Dog1.run(300);

    Cat1.swim(5);
    Cat1.run(300);

    Dog2.swim(9);
    Dog2.run(500);

    Cat2.swim(1);
    Cat2.run(50);

    System.out.println("Overall number of animals: " + Animal.animalNumber);
    System.out.println("Overall number of dogs: " + Dog.dogsNumber);
    System.out.println("Overall number of cats: " + Cat.catsNumber);
    }
}
