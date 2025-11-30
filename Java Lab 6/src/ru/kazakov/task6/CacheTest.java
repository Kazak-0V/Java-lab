package ru.kazakov.task6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CacheTest {

    @Test
    public void testCacheWithMultipleAreas() {
        // Arrange & Act
        Class<?> clazz = DatabaseService.class;

        // Assert
        assertTrue(clazz.isAnnotationPresent(Cache.class));
        Cache cache = clazz.getAnnotation(Cache.class);
        String[] areas = cache.value();

        assertEquals(3, areas.length);
        assertArrayEquals(new String[]{"users", "products", "orders"}, areas);
    }

    @Test
    public void testEmptyCacheArray() {
        // Arrange & Act
        Class<?> clazz = EmptyCacheService.class;

        // Assert
        assertTrue(clazz.isAnnotationPresent(Cache.class));
        Cache cache = clazz.getAnnotation(Cache.class);
        String[] areas = cache.value();

        assertEquals(0, areas.length);
    }

    @Test
    public void testNoCacheAnnotation() {
        // Arrange & Act
        Class<?> clazz = EmptyCacheService.class;

        // Assert
        assertFalse(clazz.isAnnotationPresent(Cache.class));
    }

    // Мок-тест без Mockito (простая имитация)
    @Test
    public void testCacheAccessSimulation() {
        // Arrange
        Class<?> clazz = DatabaseService.class;
        Cache cache = clazz.getAnnotation(Cache.class);
        String[] areas = cache.value();

        // Act - имитируем обращение к кешу
        boolean cacheHit = false;
        String requestedArea = "users";

        for (String area : areas) {
            if (area.equals(requestedArea)) {
                cacheHit = true;
                break;
            }
        }

        // Assert
        assertTrue(cacheHit, "Должен найти 'users' в кешируемых областях");
    }

    @Test
    public void testNoCachingForEmptyArray() {
        // Arrange
        Class<?> clazz = EmptyCacheService.class;
        Cache cache = clazz.getAnnotation(Cache.class);
        String[] areas = cache.value();

        // Act - имитируем проверку кеша
        boolean shouldCache = areas.length > 0;

        // Assert
        assertFalse(shouldCache, "Не должно производиться кеширование для пустого массива");
    }
}