package ru.kazakov.task6;

/**
 * Класс DatabaseService представляет сервис работы с базой данных.
 * Использует кеширование для трех областей: users, products, orders.
 */
@Cache({"users", "products", "orders"})
public class DatabaseService {
}