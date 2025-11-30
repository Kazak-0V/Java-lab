package ru.kazakov.task3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToStringTest {

    @Test
    public void testToStringIncludesYesFields() {
        // Arrange
        Person person = new Person("Иван", 25, "Москва");

        // Act
        String result = ToStringHandler.generateToString(person);

        // Assert
        assertTrue(result.contains("name=Иван"));
        assertTrue(result.contains("city=Москва"));
    }

    @Test
    public void testToStringExcludesNoFields() {
        // Arrange
        Person person = new Person("Иван", 25, "Москва");

        // Act
        String result = ToStringHandler.generateToString(person);

        // Assert
        assertFalse(result.contains("age=25"));
        assertFalse(result.contains("age="));
    }

    @Test
    public void testToStringFormat() {
        // Arrange
        Person person = new Person("Иван", 25, "Москва");

        // Act
        String result = ToStringHandler.generateToString(person);

        // Assert
        assertTrue(result.startsWith("Person["));
        assertTrue(result.endsWith("]"));
        assertTrue(result.contains("name=Иван, city=Москва") ||
                result.contains("city=Москва, name=Иван"));
    }
}