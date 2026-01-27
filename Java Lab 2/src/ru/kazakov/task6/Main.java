package ru.kazakov.task6;


public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction f3 = new Fraction(3, 4);
        Fraction f4 = new Fraction(2, 5);

        System.out.println("Созданные дроби:");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f4 = " + f4);

        System.out.println("\nПримеры операций:");

        // Сложение
        Fraction sum = f1.add(f2);
        System.out.println(f1 + " + " + f2 + " = " + sum);

        // Вычитание
        Fraction diff = f1.subtract(f2);
        System.out.println(f1 + " - " + f2 + " = " + diff);

        // Умножение
        Fraction product = f1.multiply(f2);
        System.out.println(f1 + " * " + f2 + " = " + product);

        // Деление
        Fraction quotient = f1.divide(f2);
        System.out.println(f1 + " / " + f2 + " = " + quotient);

        // Операции с целыми числами
        System.out.println("\nОперации с целыми числами:");
        System.out.println(f1 + " + 2 = " + f1.add(2));
        System.out.println(f1 + " - 2 = " + f1.subtract(2));
        System.out.println(f1 + " * 3 = " + f1.multiply(3));
        System.out.println(f1 + " / 2 = " + f1.divide(2));


        //  Посчитать f1.sum(f2).div(f3).minus(5)
        System.out.println("\nВычисление f1.sum(f2).div(f3).minus(5):");
        System.out.println("f1 = " + f1 + ", f2 = " + f2 + ", f3 = " + f3);

        Fraction result = f1.add(f2).divide(f3).subtract(5);
        System.out.println("f1 + f2 = " + f1.add(f2));
        System.out.println("(f1 + f2) / f3 = " + f1.add(f2).divide(f3));
        System.out.println("((f1 + f2) / f3) - 5 = " + result);
        System.out.println("\nИтог: " + f1 + " + " + f2 + " / " + f3 + " - 5 = " + result);
    }
}