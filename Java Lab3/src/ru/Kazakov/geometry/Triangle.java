package ru.Kazakov.geometry;

public class Triangle extends Shape {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point a, Point b, Point c) {
        this.pointA = a;
        this.pointB = b;
        this.pointC = c;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.pointA = new Point(x1, y1);
        this.pointB = new Point(x2, y2);
        this.pointC = new Point(x3, y3);
    }

    @Override
    public double getArea() {
        // Формула площади через координаты вершин
        double area = Math.abs(
                (pointA.getX() * (pointB.getY() - pointC.getY()) +
                        pointB.getX() * (pointC.getY() - pointA.getY()) +
                        pointC.getX() * (pointA.getY() - pointB.getY())) / 2.0
        );
        return area;
    }

    @Override
    public String getName() {
        return "Треугольник";
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }
}