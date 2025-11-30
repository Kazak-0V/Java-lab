package ru.kazakov.task5;

/**
 * Обработчик для вывода значений свойств аннотации @Two.
 * Показывает строковое и числовое значения, указанные в аннотации.
 *
 * @version 1.0
 */
public class TwoHandler {

    /**
     * Выводит значения свойств аннотации @Two для указанного класса.
     * Показывает оба обязательных свойства: строковое и числовое.
     *
     * @param cls класс для анализа аннотации @Two
     */
    public static void printTwoProperties(Class cls) {
        System.out.println("Анализ класса: " + cls.getSimpleName());

        if (cls.isAnnotationPresent(Two.class)) {
            Two ann = (Two) cls.getAnnotation(Two.class);

            System.out.println("Свойство first: " + ann.first());
            System.out.println("Свойство second: " + ann.second());
        } else {
            System.out.println("Аннотация @Two не найдена");
        }
    }
}