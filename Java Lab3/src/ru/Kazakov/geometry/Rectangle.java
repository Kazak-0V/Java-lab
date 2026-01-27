package ru.Kazakov.geometry;

public class Rectangle extends Shape {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public Rectangle(double x, double y, double width, double height) {
        this.topLeft = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getName() {
        if (width == height) {
            return "Квадрат";
        }
        return "Прямоугольник";
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}