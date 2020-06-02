package ru.geekbrains.JavaCoreBacicLevel.homeWork6;

public class Dog extends Animal {
    static int dogsNumber;
    int runLimit;   // Добавлены runLimit и swimLimit, чтобы сделать разброс в ограничениях
    int swimLimit;  // для собак (5 задание)

    public Dog(String name, String color, int age, int runLimit, int swimLimit) {
        super(name, color, age);
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        dogsNumber++;
    }

    @Override
    public void run(int distance) {
        if (distance > runLimit) {
            System.out.println("Dog " + name + " (" + color + " color, " + age + " years old) ran its runLimit " +
                            runLimit + " metres and tyred");
        } else {
            System.out.println("Dog " + name + " (" + color + " color, " + age + " years old) ran " + distance +
                    " metres");
        }
    }

    @Override
    public void swim(int distance){
        if (distance > swimLimit) {
            System.out.println("Dog " + name + " (" + color + " color, " + age + " years old) swam its swimLimit " +
                    swimLimit + " metres and tyred");
        } else {
            System.out.println("Dog " + name + " (" + color + " color, " + age + " years old) swam " + distance +
                    " metres");
        }
    }
}
