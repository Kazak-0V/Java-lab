package ru.kazakov.task1;

/**
 * Главный класс приложения для демонстрации работы аннотации @Invoke.
 * Создает тестовый объект и запускает обработчик.
 *
 * @version 1.0
 */
public class Main {

    /**
     * Точка входа в приложение.
     * Демонстрирует автоматический вызов методов с аннотацией @Invoke.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        TestClass testObj = new TestClass();
        InvokeHandler.k(testObj);
    }
}