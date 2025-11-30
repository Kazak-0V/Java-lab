package ru.Kazakov.task3;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List unique(List list1, List list2) {
        List result = new ArrayList();

        for (int i = 0; i < list1.size(); i++) {
            Object item = list1.get(i);
            if (!list2.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            Object item = list2.get(i);
            if (!list1.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
}