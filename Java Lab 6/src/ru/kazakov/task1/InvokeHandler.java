package ru.kazakov.task1;

import java.lang.reflect.Method;

/**
 * Обработчик для автоматического вызова методов с аннотацией @Invoke.
 * Использует Reflection API для поиска и выполнения помеченных методов.
 *
 * @version 1.0
 */
public class InvokeHandler {

    /**
     * Находит и выполняет все методы объекта, помеченные аннотацией @Invoke.
     *
     * @param object объект, методы которого нужно проанализировать и выполнить
     */
    public static void k(Object object) {
        // класс объекта
        Class objectClass = object.getClass();

        // все методы
        Method[] allMethods = objectClass.getDeclaredMethods();

        System.out.println("Всего методов: " + allMethods.length);

        int invokedCount = 0;

        // перебираем методы
        for (int i = 0; i < allMethods.length; i++) {
            Method method = allMethods[i];

            // есть ли аннотация @Invoke
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    // вызываем метод
                    method.invoke(object);
                    invokedCount++;
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        System.out.println("Всего вызвано методов: " + invokedCount);
    }
}