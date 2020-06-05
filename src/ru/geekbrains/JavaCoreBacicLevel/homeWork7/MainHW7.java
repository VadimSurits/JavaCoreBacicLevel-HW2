package ru.geekbrains.JavaCoreBacicLevel.homeWork7;

import ru.geekbrains.JavaCoreBacicLevel.homeWork5.Sotrudnik;

public class MainHW7 {
    public static void main(String[] args) {
        Cat[] cat = new Cat[6];      // Задание 4
        cat[0] = new Cat("Barsik", 20, false);
        cat[1] = new Cat("Shizik", 22, false);
        cat[2] = new Cat("Luntik", 15, false);
        cat[3] = new Cat("Dodik", 18, false);
        cat[4] = new Cat("Chudik", 10, false);
        cat[5] = new Cat("Zhirdos", 25, false);  // Для кота Zhirdos еды будет
                                                                    // недостаточно (задание 4)
        Plate plate = new Plate(100);

        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
        }
        for (int i = 0; i < cat.length; i++) {
            cat[i].satietyInfo();                        // Задание 5
        }
    }
}
