package ru.kazakov.task3;

/**
 * Главный класс для демонстрации работы аннотации @ToString.
 * Показывает разницу между обычным и аннотированным toString().
 *
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа в приложение.
     * Демонстрирует выборочное включение полей в строковое представление.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Person person = new Person("Иван", 25, "Москва");

        System.out.println("toString (только @ToString(true)):");
        String customToString = ToStringHandler.generateToString(person);
        System.out.println(customToString);
    }
}