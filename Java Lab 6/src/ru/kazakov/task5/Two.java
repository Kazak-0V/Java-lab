package ru.kazakov.task5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация с двумя обязательными свойствами разных типов.
 * Демонстрирует работу с аннотациями, имеющими несколько параметров.
 *
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    /**
     * Строковое свойство аннотации
     *
     * @return строковое значение
     */
    String first();

    /**
     * Числовое свойство аннотации
     *
     * @return целочисленное значение
     */
    int second();
}