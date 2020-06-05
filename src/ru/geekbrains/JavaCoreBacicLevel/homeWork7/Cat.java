package ru.geekbrains.JavaCoreBacicLevel.homeWork7;

public class Cat {
    String name;
    int appetite;
    boolean satiety;   // Задание 3

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat(Plate plate){
        if(plate.foodDecrease(appetite)){
            satiety = true;
            System.out.println(name + " has eaten " + appetite + " food from the plate");
        } else{
            System.out.println(name + " ate nothing, because there is not enough food for " + name + " on the plate.");
        }
        plate.info();
    }

    public void satietyInfo(){
        System.out.println("The satiety of " + name + " = " + satiety);
    }
}
