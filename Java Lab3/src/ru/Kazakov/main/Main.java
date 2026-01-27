package ru.Kazakov.main;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;


public class Main {

    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }

    public static void main(String[] args) {
        // Возведение в степень
        if (args.length < 2) {
            System.out.println("Необходимо передать два числа: основание и степень");
            return;
        }

        try {
            double result = power(args[0], args[1]);
            System.out.println(args[0] + "^" + args[1] + " = " + result);
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: аргументы должны быть целыми числами");
            return;
        }

        System.out.println("ДЕМОНСТРАЦИЯ ДРУГИХ МОДУЛЕЙ:\n");

        Demo.showGeometry();
        Demo.showCities();
        Demo.showEquals();
    }
}