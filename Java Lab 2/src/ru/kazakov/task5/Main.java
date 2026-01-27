package ru.kazakov.task5;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Пример 1: Конструктор с только названием
        System.out.println("Пример 1: Конструктор с только названием");
        City city1 = new City("Москва");
        System.out.println(city1);

        // Пример 2: Конструктор с названием и маршрутами
        System.out.println("\nПример 2: Конструктор с названием и маршрутами");

        City spb = new City("Санкт-Петербург");
        City kazan = new City("Казань");

        Map<City, Integer> routes = new HashMap<>();
        routes.put(spb, 700);
        routes.put(kazan, 800);

        City moscowWithRoutes = new City("Москва", routes);
        System.out.println(moscowWithRoutes);
    }
}
