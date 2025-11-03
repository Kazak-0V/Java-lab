package ru.Kazakov.task3a;

import java.util.*;
import java.util.function.Function;

public class Main {

    public static <T, P> List<P> map(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Строки -> длины
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = map(strings, String::length);
        System.out.println("Строки: " + strings);
        System.out.println("Длины: " + lengths);

        // Числа -> модули
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> absolute = map(numbers, n -> Math.abs(n));
        System.out.println("Числа: " + numbers);
        System.out.println("Модули: " + absolute);

        // Массивы -> максимумы 
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

        List<Integer> maxValues = map(arrays, arr -> {
            int max = arr[0];
            for (int num : arr) {
                if (num > max) max = num;
            }
            return max;
        });

        System.out.println("Массивы: " + Arrays.deepToString(arrays.toArray()));
        System.out.println("Максимумы: " + maxValues);

        scanner.close();
    }

}
