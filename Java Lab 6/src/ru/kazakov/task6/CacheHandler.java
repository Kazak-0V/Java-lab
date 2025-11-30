package ru.kazakov.task6;

/**
 * Обработчик для вывода информации о кешируемых областях.
 * Показывает области кеширования, указанные в аннотации @Cache.
 *
 * @version 1.0
 */
public class CacheHandler {

    /**
     * Выводит список кешируемых областей для указанного класса.
     * Показывает все области кеширования или сообщение о пустом списке.
     *
     * @param cls класс для анализа аннотации @Cache
     */
    public static void printCacheAreas(Class cls) {
        System.out.println("Анализ класса: " + cls.getSimpleName());

        if (cls.isAnnotationPresent(Cache.class)) {
            Cache ann = (Cache) cls.getAnnotation(Cache.class);
            String[] areas = ann.value();

            if (areas.length > 0) {
                System.out.println("Кешируемые области:");
                for (int i = 0; i < areas.length; i++) {
                    System.out.println("  - " + areas[i]);
                }
            } else {
                System.out.println("Список кешируемых областей пуст");
            }
        } else {
            System.out.println("Аннотация @Cache не найдена");
        }
    }
}