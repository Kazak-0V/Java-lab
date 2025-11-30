package ru.Kazakov.task4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filename = "abiturients.txt";

        // Читаем данные из файла
        List<Abiturient> allAbiturients = AbiturientProcessor.readAbiturients(filename);
        System.out.println("Всего абитуриентов: " + allAbiturients.size());

        // Находим неудачников
        List<Abiturient> failedAbiturients = AbiturientProcessor.findFailedAbiturients(allAbiturients);
        System.out.println("\nАбитуриенты, не допущенные к экзаменам:");

        if (failedAbiturients.isEmpty()) {
            System.out.println("Все абитуриенты прошли отбор!");
        } else {
            for (Abiturient abiturient : failedAbiturients) {
                System.out.println(abiturient.getFullName() +
                        " (баллы: " + abiturient.getScore1() +
                        ", " + abiturient.getScore2() + ")");
            }
        }

        // Статистика
        System.out.println("\nСтатистика");
        System.out.println("Всего: " + allAbiturients.size());
        System.out.println("Прошли: " + (allAbiturients.size() - failedAbiturients.size()));
        System.out.println("Не прошли: " + failedAbiturients.size());
    }
}