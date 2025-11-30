package ru.Kazakov.task8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class PersonProcessor {

    public static Map<Integer, List<String>> groupPeopleByNumber(String filename) {
        try {
            // Читаем все строки из файла
            List<String> lines = Files.readAllLines(Paths.get(filename));

            // Обработка через Stream
            Map<Integer, List<String>> result = lines.stream()
                    .map(line -> {  // Преобразуем строки в объекты Person
                        String[] parts = line.split(":");
                        if (parts.length == 2) {
                            try {
                                String name = parts[0].trim();
                                Integer number = Integer.parseInt(parts[1].trim());
                                return new Person(name, number);
                            } catch (NumberFormatException e) {
                                // Если номер не число, возвращаем Person с number = null
                                return new Person(parts[0].trim(), null);
                            }
                        }
                        return new Person(line.trim(), null);
                    })
                    .filter(person -> person.getNumber() != null)  // Убираем людей без номеров
                    .map(person -> {  // Форматируем имена
                        String name = person.getName();
                        if (name != null && !name.isEmpty()) {
                            // Первая буква заглавная, остальные маленькие
                            String formattedName = name.substring(0, 1).toUpperCase() +
                                    name.substring(1).toLowerCase();
                            return new Person(formattedName, person.getNumber());
                        }
                        return person;
                    })
                    .collect(Collectors.groupingBy(  // Группируем по номерам
                            Person::getNumber,
                            Collectors.mapping(
                                    Person::getName,
                                    Collectors.toList()
                            )
                    ));

            return result;

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return new HashMap<>();
        }
    }
}