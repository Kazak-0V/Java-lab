public class Main {
    public static void main(String[] args) {
        // Точка координат
        Point point1 = new Point(2, 3);
        Point point2 = new Point(-1, 4);
        Point point3 = new Point(0, -5);

        System.out.println("Точка 1: " + point1.toString());
        System.out.println("Точка 2: " + point2.toString());
        System.out.println("Точка 3: " + point3.toString());
        System.out.println();

        // Имена
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name name3 = new Name("Маяковский", "Владимир");

        System.out.println("Имя 1: " + name1.toString());
        System.out.println("Имя 2: " + name2.toString());
        System.out.println("Имя 3: " + name3.toString());
        System.out.println();

        // Прямая
        // 1
        Point start1 = new Point(1, 3);
        Point end1 = new Point(23, 8);
        Line line1 = new Line(start1, end1);

        // 2
        Point start2 = new Point(5, 10);
        Point end2 = new Point(25, 10);
        Line line2 = new Line(start2, end2);

        // 3
        Line line3 = new Line(start1, end2);

        System.out.println("Начальное состояние:");
        System.out.println("Линия 1: " + line1.toString());
        System.out.println("Линия 2: " + line2.toString());
        System.out.println("Линия 3: " + line3.toString());
        System.out.println();

        // 4
        System.out.println("После изменения координат линий 1 и 2:");
        start1.setX(10);
        start1.setY(15);
        end1.setX(30);
        end1.setY(20);

        start2.setX(8);
        start2.setY(12);
        end2.setX(28);
        end2.setY(12);

        System.out.println("Линия 1: " + line1.toString());
        System.out.println("Линия 2: " + line2.toString());
        System.out.println("Линия 3: " + line3.toString());
        System.out.println();

        // 5
        System.out.println("После создания новых точек для линии 1:");
        Point newStart1 = new Point(50, 60);
        Point newEnd1 = new Point(80, 65);
        line1.setStart(newStart1);
        line1.setEnd(newEnd1);

        System.out.println("Линия 1: " + line1.toString());
        System.out.println("Линия 2: " + line2.toString());
        System.out.println("Линия 3: " + line3.toString());
        System.out.println();

        // Города
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");

        // Из A
        a.addPath(b, 5);
        a.addPath(f, 1);
        a.addPath(d, 6);

        // Из B
        b.addPath(a, 5);
        b.addPath(c, 3);

        // Из C
        c.addPath(b, 3);
        c.addPath(d, 4);

        // Из D
        d.addPath(c, 4);
        d.addPath(a, 6);
        d.addPath(e, 2);

        // Из E
        e.addPath(f, 2);

        // Из F
        f.addPath(e, 2);
        f.addPath(b, 1);

        System.out.println("Схема городов и путей:");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println();

        // Дроби
        // 1
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        Fraction f3 = new Fraction(3, 4);

        System.out.println("Созданные дроби:");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println();

        // 2-3
        System.out.println("Примеры операций:");
        System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
        System.out.println(f1 + " * " + f3 + " = " + f1.multiply(f3));
        System.out.println(f1 + " / " + f3 + " = " + f1.div(f3));
        System.out.println(f1 + " + 2 = " + f1.sum(2));
        System.out.println();

        // 4
        System.out.println("Вычисление f1.sum(f2).div(f3).minus(5):");
        Fraction result = f1.sum(f2).div(f3).minus(5);
        System.out.println(f1 + " + " + f2 + " / " + f3 + " - 5 = " + result);
    }
}