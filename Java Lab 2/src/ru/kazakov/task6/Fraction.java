package ru.kazakov.task6;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    // Вспомогательный метод для нахождения НОД
    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Сокращение дроби
    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        // Знак храним в числителе
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    // Операции с другой дробью
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    // Операции с целым числом
    public Fraction add(int number) {
        return this.add(new Fraction(number, 1));
    }

    public Fraction subtract(int number) {
        return this.subtract(new Fraction(number, 1));
    }

    public Fraction multiply(int number) {
        return this.multiply(new Fraction(number, 1));
    }

    public Fraction divide(int number) {
        if (number == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return this.divide(new Fraction(number, 1));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}