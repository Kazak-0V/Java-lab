package ru.Kazakov.task1;

public interface FractionInterface {
    double getDecimalValue();           // получение вещественного значения
    void setNumerator(int numerator);   // установка числителя
    void setDenominator(int denominator); // установка знаменателя
    int getNumerator();                 // получение числителя
    int getDenominator();               // получение знаменателя
}