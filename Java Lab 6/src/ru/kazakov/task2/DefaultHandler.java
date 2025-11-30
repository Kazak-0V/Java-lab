package ru.kazakov.task2;

import java.lang.reflect.Field;

/**
 * Обработчик для вывода информации об аннотациях @Default.
 * Показывает типы по умолчанию для классов и полей.
 *
 * @version 1.0
 */
public class DefaultHandler {

    /**
     * Выводит информацию о типах по умолчанию для указанного класса.
     * Показывает аннотации на самом классе и его полях.
     *
     * @param cls класс для анализа
     */
    public static void showDefaults(Class cls) {
        System.out.println("Класс: " + cls.getSimpleName());

        // аннотация класса
        if (cls.isAnnotationPresent(Default.class)) {
            Default ann = (Default) cls.getAnnotation(Default.class);
            System.out.println("Класс: тип по умолчанию - " + ann.value().getSimpleName());
        }

        // аннотация полей
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(Default.class)) {
                Default ann = (Default) field.getAnnotation(Default.class);
                System.out.println("Поле " + field.getName() +
                        " имеет тип по умолчанию: " + ann.value().getSimpleName());
            }
        }
    }
}