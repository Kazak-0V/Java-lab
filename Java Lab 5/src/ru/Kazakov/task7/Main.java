package ru.Kazakov.task7;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(3, 4));
        points.add(new Point(1, 2));
        points.add(new Point(5, -3));  // отрицательный Y
        points.add(new Point(2, 2));   // X=Y (должен быть убран)
        points.add(new Point(3, 4));   // дубликат (должен быть убран)
        points.add(new Point(1, -5));  // отрицательный Y
        points.add(new Point(4, 4));   // X=Y (должен быть убран)

        System.out.println("Исходные точки:");
        for (Point point : points) {
            System.out.println(point);
        }

        // Обрабатываем через Stream
        Polyline result = PointProcessor.processPoints(points);

        System.out.println("\nРезультат - ломаная линия:");
        System.out.println(result);
    }
}