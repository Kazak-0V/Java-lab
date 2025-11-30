package ru.Kazakov.task1;

public class Main {
    public static void main(String[] args) {
        // Создаем обычную дробь
        FractionInterface fraction = new MutableFraction(3, 4);
        System.out.println("Создана дробь: " + fraction);

        // Обертываем в кэширующую версию
        FractionInterface cachedFraction = new CachedFraction(fraction);

        System.out.println("Первый вызов");
        double value1 = cachedFraction.getDecimalValue();
        System.out.println("Результат: " + value1);

        System.out.println("\nВторой вызов");
        double value2 = cachedFraction.getDecimalValue();
        System.out.println("Результат: " + value2);

        System.out.println("\nИзменение дроби");
        System.out.println("Меняем числитель на 1:");
        cachedFraction.setNumerator(1);
        System.out.println("Дробь теперь: " + cachedFraction);

        System.out.println("\nВызов после изменения:");
        double value3 = cachedFraction.getDecimalValue();
        System.out.println("Результат: " + value3);

        System.out.println("\nПроверка равенства");
        FractionInterface f1 = new MutableFraction(1, 2);
        FractionInterface f2 = new MutableFraction(2, 4);
        FractionInterface f3 = new MutableFraction(1, 2);

        System.out.println(f1 + " = " + f2 + " : " + f1.equals(f2));
        System.out.println(f1 + " = " + f3 + " : " + f1.equals(f3));

        System.out.println("\nОтрицательные значения");
        FractionInterface negative = new MutableFraction(1, -2);
        System.out.println("Дробь: " + negative);
        System.out.println("Значение: " + negative.getDecimalValue());
    }
}