package ru.Kazakov.task8;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Обрабатываем файл
        String filename = "people.txt";
        Map<Integer, List<String>> result = PersonProcessor.groupPeopleByNumber(filename);

        // Выводим результат
        System.out.println("Результат группировки:");
        System.out.println(result);
    }
}