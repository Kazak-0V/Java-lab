package ru.kazakov.task4;

/**
 * Класс Product представляет товар с базовой информацией.
 * Используется для демонстрации аннотации @Validate.
 */
@Validate({String.class, Integer.class, Double.class})
public class Product {
    /**
     * Название товара
     */
    private String name;

    /**
     * Цена товара
     */
    private double price;

    /**
     * Количество товара на складе
     */
    private int quantity;
}