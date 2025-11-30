package ru.Kazakov.task1;

public class MutableFraction implements FractionInterface {
    private int numerator;
    private int denominator;

    // Конструктор
    public MutableFraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        normalizeSign();
    }

    // Геттеры
    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public int getDenominator() {
        return denominator;
    }

    @Override
    public double getDecimalValue() {
        return (double) numerator / denominator;
    }

    // Сеттеры
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        normalizeSign();
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
        this.denominator = denominator;
        normalizeSign();
    }

    // Приватные методы
    private void normalizeSign() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Переопределения
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MutableFraction that = (MutableFraction) obj;
        return numerator == that.numerator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }
}