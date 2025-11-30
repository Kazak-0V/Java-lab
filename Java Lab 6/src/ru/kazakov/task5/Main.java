package ru.kazakov.task5;

/**
 * Главный класс для демонстрации работы аннотации @Two.
 * Показывает извлечение двух разных типов свойств из аннотации.
 *
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа в приложение.
     * Запускает обработчик для вывода значений свойств аннотации @Two.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        TwoHandler.printTwoProperties(Student.class);
    }
}