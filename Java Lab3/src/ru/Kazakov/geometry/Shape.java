package ru.Kazakov.geometry;

public abstract class Shape {
    public abstract double getArea();
    public abstract String getName();

    @Override
    public String toString() {
        return getName() + " (площадь: " + getArea() + ")";
    }
}