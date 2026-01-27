package ru.Kazakov.geometry;

public class Point3D extends Point {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // Переопределяем toString для трехмерной точки
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

    // Дополнительный метод для перемещения в 3D пространстве
    public void move(double dx, double dy, double dz) {
        setX(getX() + dx);
        setY(getY() + dy);
        z += dz;
    }

    // Метод для вычисления расстояния до другой точки в 3D
    public double distanceTo(Point3D other) {
        double dx = getX() - other.getX();
        double dy = getY() - other.getY();
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}