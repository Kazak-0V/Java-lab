package ru.kazakov.task2;

/**
 * Главный класс для демонстрации работы аннотации @Default.
 *
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа в приложение.
     * Запускает обработчик для вывода информации о типах по умолчанию.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        DefaultHandler.showDefaults(User.class);
    }
}