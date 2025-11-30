package ru.Kazakov.task7;

import java.util.List;
import java.util.stream.Collectors;

public class PointProcessor {

    public static Polyline processPoints(List<Point> points) {
        Polyline polyline = new Polyline();

        // Stream обработка по условию задачи:
        // 1. Взять все Point в разных координатах (убрать дубликаты)
        // 2. Убрать с одинаковыми X,Y
        // 3. Отсортировать по X
        // 4. Отрицательные Y сделать положительными
        // 5. Собрать в ломаную

        List<Point> processedPoints = points.stream()
                .distinct()  // убрать дубликаты (нужен equals в Point)
                .filter(point -> point.getX() != point.getY())  // убрать где X=Y
                .sorted((p1, p2) -> Integer.compare(p1.getX(), p2.getX()))  // сортировка по X
                .map(point -> {
                    // Отрицательные Y сделать положительными
                    if (point.getY() < 0) {
                        return new Point(point.getX(), -point.getY());
                    }
                    return point;
                })
                .collect(Collectors.toList());

        // Добавляем обработанные точки в ломаную
        for (Point point : processedPoints) {
            polyline.addPoint(point);
        }

        return polyline;
    }
}