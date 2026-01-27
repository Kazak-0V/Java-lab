package ru.kazakov.task4;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        City cityA = new City("A");
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");
        City cityE = new City("E");
        City cityF = new City("F");

        // Из A можно попасть в F(1), B(5), D(6)
        cityA.addRoute(cityF, 1);
        cityA.addRoute(cityB, 5);
        cityA.addRoute(cityD, 6);

        // Из B можно попасть в A(5), C(3)
        cityB.addRoute(cityA, 5);
        cityB.addRoute(cityC, 3);

        // Из C можно попасть в B(3), D(4)
        cityC.addRoute(cityB, 3);
        cityC.addRoute(cityD, 4);

        // Из D можно попасть в C(4), E(2), A(6)
        cityD.addRoute(cityC, 4);
        cityD.addRoute(cityE, 2);
        cityD.addRoute(cityA, 6);

        // Из F можно попасть в B(1), E(2)
        cityF.addRoute(cityB, 1);
        cityF.addRoute(cityE, 2);

        // Из E можно попасть в F(2)
        cityE.addRoute(cityF, 2);

        // Выводим все города с их маршрутами
        System.out.println("Схема городов и маршрутов:");
        System.out.println(cityA);
        System.out.println(cityB);
        System.out.println(cityC);
        System.out.println(cityD);
        System.out.println(cityE);
        System.out.println(cityF);

        // Пример проверки маршрутов из города A
        System.out.println("\nПроверка маршрутов из города A:");
        for (Map.Entry<City, Integer> route : cityA.getRoutes().entrySet()) {
            System.out.println("До города " + route.getKey().getName() +
                    " стоимость: " + route.getValue());
        }
    }
}