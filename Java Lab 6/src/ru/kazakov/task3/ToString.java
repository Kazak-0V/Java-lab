package ru.kazakov.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для управления включением полей в строковое представление.
 * Определяет, должно ли поле отображаться в результате toString().
 *
 * @version 1.0
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    /**
     * Определяет, включать ли поле в строковое представление
     *
     * @return true - включать поле, false - исключать поле
     */
    boolean value() default true;
}