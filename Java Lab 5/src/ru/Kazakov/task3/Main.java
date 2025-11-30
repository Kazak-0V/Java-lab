package ru.Kazakov.task3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> L1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> L2 = Arrays.asList(4, 5, 6, 7, 8);

        List<Integer> L = ListUtils.unique(L1, L2);

        System.out.println("Список L1: " + L1);
        System.out.println("Список L2: " + L2);
        System.out.println("Результат L: " + L);
        System.out.println();

        List<String> list1 = Arrays.asList("яблоко", "банан", "апельсин");
        List<String> list2 = Arrays.asList("банан", "киви", "груша");

        List<String> result = ListUtils.unique(list1, list2);
        System.out.println("Список A: " + list1);
        System.out.println("Список B: " + list2);
        System.out.println("Результат: " + result);
    }
}