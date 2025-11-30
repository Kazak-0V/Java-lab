package ru.Kazakov.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AbiturientProcessor {

    public static List<Abiturient> readAbiturients(String filename) {
        List<Abiturient> abiturients = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filename));

            // Первая строка - количество абитуриентов
            int n = Integer.parseInt(lines.get(0));

            // Читаем данные абитуриентов
            for (int i = 1; i <= n; i++) {
                String line = lines.get(i);
                String[] parts = line.split(" ");

                if (parts.length >= 4) {
                    String lastName = parts[0];
                    String firstName = parts[1];
                    int score1 = Integer.parseInt(parts[2]);
                    int score2 = Integer.parseInt(parts[3]);

                    Abiturient abiturient = new Abiturient(lastName, firstName, score1, score2);
                    abiturients.add(abiturient);
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка формата данных: " + e.getMessage());
        }

        return abiturients;
    }

    public static List<Abiturient> findFailedAbiturients(List<Abiturient> abiturients) {
        List<Abiturient> failed = new ArrayList<>();

        for (Abiturient abiturient : abiturients) {
            if (!abiturient.isPassed()) {
                failed.add(abiturient);
            }
        }

        return failed;
    }
}