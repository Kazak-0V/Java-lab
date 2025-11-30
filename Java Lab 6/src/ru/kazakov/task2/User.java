package ru.kazakov.task2;

/**
 * Класс пользователя для демонстрации аннотации @Default.
 * Показывает использование аннотации на классе и поле.
 */
@Default(String.class)
public class User {

    /**
     * Имя пользователя с указанием типа по умолчанию Integer
     */
    @Default(Integer.class)
    private String name;

    /**
     * Возраст пользователя (без аннотации)
     */
    private int age;
}