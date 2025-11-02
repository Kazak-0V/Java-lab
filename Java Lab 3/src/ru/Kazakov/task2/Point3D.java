package ru.Kazakov.task2;

class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);  // вызов конструктора родителя
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}