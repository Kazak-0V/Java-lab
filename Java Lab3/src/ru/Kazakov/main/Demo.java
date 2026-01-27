package ru.Kazakov.main;

import ru.Kazakov.geometry.*;
import ru.Kazakov.cities.*;


public class Demo {
    public static void showGeometry() {
        System.out.println("ГЕОМЕТРИЧЕСКИЕ ФИГУРЫ");

        // Точки
        Point p1 = new Point(1, 2);
        System.out.println("Точка 1: " + p1);

        // Трехмерная точка
        Point3D p3d = new Point3D(1, 2, 3);
        System.out.println("Точка 3D: " + p3d);

        // Фигуры
        Shape[] shapes = {
                new Circle(new Point(0, 0), 5),
                new Rectangle(new Point(1, 1), 4, 4),
                new Rectangle(new Point(2, 2), 3, 6),
                new Triangle(new Point(0, 0), new Point(4, 0), new Point(2, 3))
        };

        System.out.println("\nФигуры и их площади:");
        for (Shape shape : shapes) {
            System.out.println("  " + shape);
        }
    }

    public static void showCities() {
        System.out.println("\nГОРОДА И ДОРОГИ");

        City moscow = new City("Москва");
        City spb = new City("СПб");
        City kazan = new City("Казань");

        // Добавление дороги
        moscow.addRoute(spb, 700);
        moscow.addRoute(kazan, 800);
        spb.addRoute(kazan, 1200);

        System.out.println("Обычные города:");
        System.out.println("  " + moscow);
        System.out.println("  " + spb);
        System.out.println("  " + kazan);

        // Двусторонние города
        TwoWayCity twoWay1 = new TwoWayCity("Двусторонний1");
        TwoWayCity twoWay2 = new TwoWayCity("Двусторонний2");
        twoWay1.addRoute(twoWay2, 100);

        System.out.println("\nДвусторонние города:");
        System.out.println("  " + twoWay1);
        System.out.println("  " + twoWay2);

        // Граф из задания (с уникальными именами)
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");

        // Устанавливаем ВСЕ связи из задания:
        // A → B, A → C
        A.addRoute(B, 5);
        A.addRoute(C, 10);

        // B → A, B → C, B → D
        B.addRoute(A, 5);
        B.addRoute(C, 3);
        B.addRoute(D, 7);

        // C → A
        C.addRoute(A, 2);

        // D → B, D → E
        D.addRoute(B, 4);
        D.addRoute(E, 6);

        // E → D, E → C
        E.addRoute(D, 6);
        E.addRoute(C, 8);

        System.out.println("Созданные города с маршрутами:");
        System.out.println("A: " + A);
        System.out.println("B: " + B);
        System.out.println("C: " + C);
        System.out.println("D: " + D);
        System.out.println("E: " + E);

        // Маршрут
        // Создаем схему городов из задачи 1.3.3
        City A1 = new City("A");
        City B2 = new City("B");
        City C3 = new City("C");
        City D4 = new City("D");
        City E5 = new City("E");
        City F6 = new City("F");

        // Настраиваем связи (минимально для маршрута F→D)
        A1.addRoute(F6, 1);
        A1.addRoute(B, 5);
        A1.addRoute(D, 6);
        B2.addRoute(A, 5);
        B2.addRoute(C, 3);
        C3.addRoute(B, 3);
        C3.addRoute(D, 4);
        D4.addRoute(C, 4);
        D4.addRoute(E, 2);
        D4.addRoute(A, 6);
        F6.addRoute(B, 1);
        F6.addRoute(E, 2);
        E.addRoute(F6, 2);

        // Создаем маршрут из F в D
        Route route = new Route(F6, D);
        System.out.println("Маршрут F → D: " + route);

    }

    public static void showEquals() {
        System.out.println("\nСРАВНЕНИЕ ГОРОДОВ");

        // Простое сравнение по имени (без маршрутов)
        City city1 = new City("Москва");
        City city2 = new City("Москва"); // Такое же имя
        City city3 = new City("СПб");    // Другое имя

        System.out.println("Сравнение по имени:");
        System.out.println("  city1 (Москва).equals(city2 (Москва)): " + city1.equals(city2));
        System.out.println("  city1 (Москва).equals(city3 (СПб)): " + city1.equals(city3));

        // Сравнение разных типов городов
        TwoWayCity twoWay = new TwoWayCity("Москва"); // Такое же имя
        System.out.println("\nСравнение разных типов:");
        System.out.println("  city1 (обычный).equals(twoWay (двусторонний)): " + city1.equals(twoWay));
        System.out.println("  twoWay.equals(city1): " + twoWay.equals(city1));
    }
}
