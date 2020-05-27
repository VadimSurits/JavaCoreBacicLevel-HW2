package ru.geekbrains.JavaCoreBacicLevel.homeWork5;

public class MainHW5 {
    public static void main(String[] args) {
        Sotrudnik[] employee = new Sotrudnik[5];      // Задание 4
        employee[0] = new Sotrudnik("Ivanov Ivan", "Engineer", "ii@mailbox.com",
                892312312, 30000, 30);
        employee[1] = new Sotrudnik("Sergeev Sergey", "Cleaner", "ss@mailbox.com",
                891122211, 20000, 55);
        employee[2] = new Sotrudnik("Dmitriev Dmitry", "Manager", "dd@mailbox.com",
                890000000, 60000, 50);
        employee[3] = new Sotrudnik("Vasiliev Vasily", "Accountant", "vv@mailbox.com",
                893355544, 40000, 45);
        employee[4] = new Sotrudnik("Pavlov Pavel", "Java-Developer", "pp@mailbox.com",
                897777777, 50000, 35);

        employee[0].printInfo();  // Проверка работоспособности метода из 3 задания

        System.out.println("Список сотрудников старше 40 лет:");  // Задание 5
        for (int i = 0; i < employee.length ; i++) {
            if (employee[i].age > 40) {
                employee[i].printInfo();
            }
        }
    }
}
