package ru.kazakov.task4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания классов, используемых при валидации.
 * Может применяться к классам и другим аннотациям.
 *
 * @version 1.0
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    /**
     * Массив классов, используемых для валидации
     *
     * @return массив классов для проверки
     */
    Class[] value();
}