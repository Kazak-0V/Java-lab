package ru.kazakov.task4;

/**
 * Обработчик для вывода информации о классах валидации.
 * Показывает классы, указанные в аннотации @Validate.
 *
 * @version 1.0
 */
public class ValidateHandler {

    /**
     * Выводит список классов, указанных в аннотации @Validate.
     * Показывает все классы, которые используются для проверки.
     *
     * @param cls класс для анализа аннотаций валидации
     */
    public static void printValidationClasses(Class cls) {
        System.out.println("Анализ класса: " + cls.getSimpleName());

        if (cls.isAnnotationPresent(Validate.class)) {
            Validate ann = (Validate) cls.getAnnotation(Validate.class);
            Class[] classes = ann.value();

            System.out.println("Классы для проверки:");
            for (int i = 0; i < classes.length; i++) {
                System.out.println("  - " + classes[i].getSimpleName());
            }
        } else {
            System.out.println("Аннотация @Validate не найдена");
        }
    }
}