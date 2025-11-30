package ru.kazakov.task6;

public class Main {
    public static void main(String[] args) {
        CacheHandler.printCacheAreas(DatabaseService.class);
        System.out.println("\nC пустым массивом");
        CacheHandler.printCacheAreas(EmptyCacheService.class);
    }
}

