package ru.Kazakov.task3d;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static <T, P extends Collection<T>> P collect(
            List<T> list,
            Supplier<P> collectionFactory,
            Function<T, Boolean> check
    ) {
        P result = collectionFactory.get();
        for (T item : list) {
            if (check.apply(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Разделение чисел на положительные и отрицательные
        List<Integer> numbers = Arrays.asList(1, -3, 7, -5, 0, -2);

        List<Integer> positiveNumbers = collect(
                numbers,
                ArrayList::new,
                n -> n > 0
        );

        List<Integer> negativeNumbers = collect(
                numbers,
                ArrayList::new,
                n -> n < 0
        );

        System.out.println("Числа: " + numbers);
        System.out.println("Положительные: " + positiveNumbers);
        System.out.println("Отрицательные: " + negativeNumbers);

        // Группировка строк по длине
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");

        // уникальные длины
        Set<Integer> lengths = new HashSet<>();
        for (String s : strings) {
            lengths.add(s.length());
        }

        // список для каждой длины
        Map<Integer, List<String>> groupedByLength = new HashMap<>();
        for (int length : lengths) {
            List<String> sameLength = collect(
                    strings,
                    ArrayList::new,
                    s -> s.length() == length
            );
            groupedByLength.put(length, sameLength);
        }

        System.out.println("Строки: " + strings);
        System.out.println("Сгруппированные по длине: " + groupedByLength);

        // уникальные строки
        List<String> stringsWithDuplicates = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");

        Set<String> uniqueStrings = collect(
                stringsWithDuplicates,
                HashSet::new,
                s -> true  
        );

        System.out.println("Строки с дубликатами: " + stringsWithDuplicates);
        System.out.println("Уникальные строки: " + uniqueStrings);

        scanner.close();
    }

}
