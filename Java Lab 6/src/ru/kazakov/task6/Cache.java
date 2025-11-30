package ru.kazakov.task6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания областей кеширования.
 * Определяет, какие данные должны кешироваться для класса.
 *
 * @version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * Массив имен областей кеширования
     *
     * @return массив строк с названиями кешируемых областей
     */
    String[] value() default {};
}