package ru.kazakov.task3;

public class Main {
    public static void main(String[] args) {
        // 1. Линия 1 с началом в т. {1;3} и концом в т.{23;8}
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        Line line1 = new Line(start1, end1);

        // 2. Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25
        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        Line line2 = new Line(start2, end2);

        // 3. Линия 3, которая начинается всегда там же, где начинается линия 1,
        // и заканчивается всегда там же, где заканчивается линия 2
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("Создание линий:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3: " + line3);

        // 4. После создания всех трех объектов измените координаты первой и второй линий
        System.out.println("\nИзменение координат линий 1 и 2:");
        line1.getStart().setX(10);
        line1.getStart().setY(15);
        line1.getEnd().setX(50);
        line1.getEnd().setY(20);

        line2.getStart().setX(30);
        line2.getStart().setY(5);
        line2.getEnd().setX(60);
        line2.getEnd().setY(5);

        System.out.println("Линия 1 после изменения: " + line1);
        System.out.println("Линия 2 после изменения: " + line2);
        System.out.println("Линия 3 после изменения: " + line3);

        // 5. Изменение координаты первой линии так, чтобы при этом не изменились координаты третьей линии
        System.out.println("\nИзменение линии 1 без влияния на линию 3:");
        // Создаем новые точки для линии 1
        Point newStart1 = new Point(100, 200);
        Point newEnd1 = new Point(300, 400);
        line1.setStart(newStart1);
        line1.setEnd(newEnd1);

        System.out.println("Линия 1 после второго изменения: " + line1);
        System.out.println("Линия 3 после второго изменения: " + line3);
    }
}