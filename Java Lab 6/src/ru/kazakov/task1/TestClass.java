package ru.kazakov.task1;

/**
 * Тестовый класс для демонстрации работы аннотации @Invoke.
 * Содержит методы с аннотацией и без нее.
 *
 * @version 1.0
 */
public class TestClass {

    /**
     * Метод с аннотацией @Invoke.
     * Будет вызван автоматически обработчиком.
     */
    @Invoke
    public void method1() {
        System.out.println("Метод с аннотацией @Invoke");
    }

    /**
     * Обычный метод без аннотации.
     * Не будет вызван автоматически.
     */
    public void method2() {
        System.out.println("Обычный метод");
    }

    /**
     * Метод с аннотацией @Invoke.
     * Будет вызван автоматически обработчиком.
     */
    @Invoke
    public void method3() {
        System.out.println("Метод с аннотацией @Invoke");
    }
}