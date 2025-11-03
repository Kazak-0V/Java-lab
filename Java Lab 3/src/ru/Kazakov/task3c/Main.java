package ru.Kazakov.task3c;

import java.util.*;
import java.util.function.BinaryOperator;

public class Main {

    public static <T> T reduce(List<T> list, BinaryOperator<T> operator, T defaultValue) {
        if (list.isEmpty()) {
            return defaultValue;
        }

        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = operator.apply(result, list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Строки -> одна большая строка
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        String combinedString = reduce(strings, (s1, s2) -> s1 + s2, "");
        System.out.println("Строки: " + strings);
        System.out.println("Объединенная строка: " + combinedString);

        // Числа -> сумма
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        Integer sum = reduce(numbers, (a, b) -> a + b, 0);
        System.out.println("Числа: " + numbers);
        System.out.println("Сумма: " + sum);

        // Списки чисел -> общее количество элементов 
        int listCount;
        while (true) {
            System.out.print("Сколько списков: ");
            if (scanner.hasNextInt()) {
                listCount = scanner.nextInt();
                if (listCount > 0) break;
                else System.out.println("Число должно быть больше 0");
            } else {
                System.out.println("Введите число!");
                scanner.next();
            }
        }

        List<List<Integer>> listOfLists = new ArrayList<>();

        for (int i = 0; i < listCount; i++) {
            int size;
            while (true) {
                System.out.print("Сколько чисел в списке " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    size = scanner.nextInt();
                    if (size >= 0) break;
                    else System.out.println("Число не может быть отрицательным");
                } else {
                    System.out.println("Введите число!");
                    scanner.next();
                }
            }

            List<Integer> innerList = new ArrayList<>();
            if (size > 0) {
                System.out.print("Числа для списка " + (i + 1) + ": ");
                for (int j = 0; j < size; j++) {
                    while (!scanner.hasNextInt()) {
                        System.out.println("Введите число!");
                        scanner.next();
                    }
                    innerList.add(scanner.nextInt());
                }
            }
            listOfLists.add(innerList);
        }

        // создаем общий список и берем его размер
        List<Integer> allNumbers = new ArrayList<>();
        for (List<Integer> innerList : listOfLists) {
            allNumbers.addAll(innerList);
        }
        int totalCount = allNumbers.size();

        System.out.println("Списки: " + listOfLists);
        System.out.println("Общее количество элементов: " + totalCount);

        scanner.close();
    }

}
