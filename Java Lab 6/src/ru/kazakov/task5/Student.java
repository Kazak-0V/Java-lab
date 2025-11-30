package ru.kazakov.task5;

/**
 * Класс Student представляет студента с базовой информацией.
 * Используется для демонстрации аннотации @Two с двумя параметрами.
 */
@Two(first = "Иван", second = 20)
public class Student {
    /**
     * Имя студента
     */
    private String name;

    /**
     * Возраст студента
     */
    private int age;
}