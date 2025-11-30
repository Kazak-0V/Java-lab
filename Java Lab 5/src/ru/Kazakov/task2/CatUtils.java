package ru.Kazakov.task2;

public class CatUtils {
    public static void makeCatsMeow(CatCounter[] cats) {
        for (CatCounter cat : cats) {
            cat.meow();
        }
    }
}