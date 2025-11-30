package ru.kazakov.task3;

import java.lang.reflect.Field;

/**
 * Обработчик для генерации строкового представления объектов
 * на основе аннотаций @ToString.
 * Включает в результат только поля с @ToString(true).
 *
 * @version 1.0
 */
public class ToStringHandler {

    /**
     * Генерирует строковое представление объекта, учитывая аннотации @ToString.
     * Включает только поля, помеченные @ToString(true).
     *
     * @param obj объект для преобразования в строку
     * @return строковое представление объекта с учетом аннотаций
     */
    public static String generateToString(Object obj) {
        Class cls = obj.getClass();
        StringBuilder result = new StringBuilder();
        result.append(cls.getSimpleName()).append("[");

        Field[] fields = cls.getDeclaredFields();
        boolean firstField = true;

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            if (field.isAnnotationPresent(ToString.class)) {
                ToString ann = field.getAnnotation(ToString.class);

                if (ann.value()) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(obj);

                        if (!firstField) {
                            result.append(", ");
                        }
                        result.append(field.getName()).append("=").append(value);
                        firstField = false;

                    } catch (Exception e) {
                        result.append(field.getName()).append("=ERROR");
                    }
                }
            }
        }

        result.append("]");
        return result.toString();
    }
}