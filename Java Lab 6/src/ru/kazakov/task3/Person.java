package ru.kazakov.task3;

/**
 * Класс Person представляет человека с персональными данными.
 * Используется для демонстрации выборочного включения полей в toString().
 */
@ToString(true)
public class Person {
    /**
     * Имя человека (включается в toString)
     */
    @ToString(true)
    private String name;

    /**
     * Возраст человека (исключается из toString)
     */
    @ToString(false)
    private int age;

    /**
     * Город проживания (включается в toString)
     */
    @ToString(true)
    private String city;

    /**
     * Создает новый объект Person
     *
     * @param name имя человека
     * @param age возраст человека
     * @param city город проживания
     */
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}