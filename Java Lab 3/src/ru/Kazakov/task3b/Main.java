package ru.Kazakov.task3b;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static <T> List<T> filter(List<T> list, Predicate<T> check) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (check.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Строки по длине
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "abc", "hi");
        List<String> filteredStrings = filter(strings, s -> s.length() >= 3);
        System.out.println("Строки: " + strings);
        System.out.println("После фильтра: " + filteredStrings);

        // Положительные числа
        List<Integer> numbers = Arrays.asList(1, -3, 7, -5, 0, -2);
        List<Integer> filteredNumbers = filter(numbers, n -> n > 0);
        System.out.println("Числа: " + numbers);
        System.out.println("После фильтра: " + filteredNumbers);

        // Массивы без положительных 
        int count;
        while (true) {
            System.out.print("Сколько массивов: ");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count > 0) break;
                else System.out.println("Число должно быть больше 0");
            } else {
                System.out.println("Введите число!");
                scanner.next();
            }
        }

        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int size;
            while (true) {
                System.out.print("Размер массива " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    size = scanner.nextInt();
                    if (size > 0) break;
                    else System.out.println("Размер должен быть больше 0");
                } else {
                    System.out.println("Введите число!");
                    scanner.next();
                }
            }

            int[] array = new int[size];
            System.out.print("Числа: ");
            for (int j = 0; j < size; j++) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Введите число!");
                    scanner.next();
                }
                array[j] = scanner.nextInt();
            }
            arrays.add(array);
        }

        List<int[]> resultArrays = filter(arrays, arr -> {
            for (int num : arr) {
                if (num > 0) return false;
            }
            return true;
        });

        System.out.println("Исходные: " + Arrays.deepToString(arrays.toArray()));
        System.out.println("Результат: " + Arrays.deepToString(resultArrays.toArray()));

        scanner.close();
    }

}
