package ru.Kazakov.task1;

public class CachedFraction implements FractionInterface {
    private final FractionInterface realFraction;
    private Double cachedValue;
    private boolean isCacheValid;

    // Конструктор принимает любую дробь с интерфейсом
    public CachedFraction(FractionInterface fraction) {
        this.realFraction = fraction;
        this.isCacheValid = false;
        this.cachedValue = null;
    }

    // Геттеры (просто делегируем)
    @Override
    public int getNumerator() {
        return realFraction.getNumerator();
    }

    @Override
    public int getDenominator() {
        return realFraction.getDenominator();
    }

    // Кэширующий геттер
    @Override
    public double getDecimalValue() {
        if (!isCacheValid) {
            cachedValue = realFraction.getDecimalValue();
            isCacheValid = true;
            System.out.println("Вычислено значение: " + cachedValue);
        } else {
            System.out.println("Использовано кэшированное значение: " + cachedValue);
        }
        return cachedValue;
    }

    // Сеттеры сбрасывают кэш
    @Override
    public void setNumerator(int numerator) {
        realFraction.setNumerator(numerator);
        invalidateCache();
    }

    @Override
    public void setDenominator(int denominator) {
        realFraction.setDenominator(denominator);
        invalidateCache();
    }

    private void invalidateCache() {
        isCacheValid = false;
        cachedValue = null;
        System.out.println("Кэш сброшен");
    }

    @Override
    public String toString() {
        return realFraction.toString();
    }
}