package ru.kazakov.task4;

/**
 * Главный класс для демонстрации работы аннотации @Validate.
 * Показывает классы, используемые для валидации объекта.
 *
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа в приложение.
     * Запускает обработчик для вывода информации о классах валидации.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        ValidateHandler.printValidationClasses(Product.class);
    }
}