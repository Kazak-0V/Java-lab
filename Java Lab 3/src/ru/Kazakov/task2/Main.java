package ru.Kazakov.task2;

import java.util.Scanner;

public class Main {

    public static void putOriginPoint(Box<? super Point3D> box) {
        box.put(new Point3D(0, 0, 0));
    }

    private static int getCoordinate(Scanner scanner, String coordName) {
        while (true) {
            try {
                System.out.print(coordName + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число для " + coordName);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Коробки разных типов
        Box<Point3D> exactBox = new Box<>();
        Box<Point> parentBox = new Box<>();
        Box<Object> objectBox = new Box<>();

        // Точка начала отсчета (0,0,0)
        putOriginPoint(exactBox);
        putOriginPoint(parentBox);
        putOriginPoint(objectBox);

        System.out.println("Коробка Point3D: " + exactBox);
        System.out.println("Коробка Point: " + parentBox);
        System.out.println("Коробка Object: " + objectBox);

        System.out.println("\nСоздание новой точки:");
        int x = getCoordinate(scanner, "X");
        int y = getCoordinate(scanner, "Y");
        int z = getCoordinate(scanner, "Z");

        Point3D customPoint = new Point3D(x, y, z);
        Box<Point3D> customBox = new Box<>();
        customBox.put(customPoint);

        System.out.println("Новая точка: " + customPoint);
        System.out.println("В коробке: " + customBox);

        scanner.close();
    }
}