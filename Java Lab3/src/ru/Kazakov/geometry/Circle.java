package ru.Kazakov.geometry;

public class Circle extends Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "Круг";
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }
}