package ru.Kazakov.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ConsonantProcessor {

    // Звонкие согласные
    private static final Set<Character> VOICED = Set.of(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р',
            'Б', 'В', 'Г', 'Д', 'Ж', 'З', 'Й', 'Л', 'М', 'Н', 'Р'
    );

    public static List<Character> findConsonants(String file) {
        try {
            // Читаем текст
            String text = Files.readString(Paths.get(file));

            // Делим на слова
            String[] words = text.split("[\\s\\p{Punct}]+");

            // Для хранения: буква -> слова
            Map<Character, Set<String>> map = new HashMap<>();

            // Смотрим каждое слово
            for (String word : words) {
                if (word.isEmpty()) continue;

                // Уникальные буквы в слове
                Set<Character> letters = new HashSet<>();

                // Ищем звонкие согласные
                for (char c : word.toCharArray()) {
                    if (VOICED.contains(c)) {
                        letters.add(Character.toLowerCase(c));
                    }
                }

                // Добавляем в общую map
                for (char letter : letters) {
                    map.putIfAbsent(letter, new HashSet<>());
                    map.get(letter).add(word.toLowerCase());
                }
            }

            // Берем только те, что в разных словах
            List<Character> result = new ArrayList<>();
            for (Map.Entry<Character, Set<String>> entry : map.entrySet()) {
                if (entry.getValue().size() > 1) {
                    result.add(entry.getKey());
                }
            }

            // Сортируем
            Collections.sort(result);

            return result;

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void printResult(List<Character> list) {
        if (list.isEmpty()) {
            System.out.println("Нет подходящих букв");
            return;
        }

        System.out.println("Результат:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}