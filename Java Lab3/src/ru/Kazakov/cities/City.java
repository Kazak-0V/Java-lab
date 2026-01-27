package ru.Kazakov.cities;

import java.util.*;

public class City {
    private String name;
    private Map<City, Integer> routes;

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public void addRoute(City city, int cost) {
        if (city == null) throw new IllegalArgumentException("Город не может быть null");
        if (city == this) throw new IllegalArgumentException("Нельзя добавить дорогу к самому себе");
        if (routes.containsKey(city)) throw new IllegalStateException("Дорога уже существует: " + name + " → " + city.name);
        if (cost <= 0) throw new IllegalArgumentException("Стоимость должна быть положительной");
        routes.put(city, cost);
    }

    // Метод для обновления существующей дороги
    public void updateRoute(City city, int newCost) {
        if (!routes.containsKey(city)) {
            throw new IllegalStateException("Дороги не существует: " + name + " → " + city.name);
        }
        if (newCost <= 0) throw new IllegalArgumentException("Стоимость должна быть положительной");
        routes.put(city, newCost);
    }

    public String getName() { return name; }
    public Map<City, Integer> getRoutes() { return new HashMap<>(routes); }
    public boolean hasRouteTo(City city) { return routes.containsKey(city); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City other = (City) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append(": ");
        boolean first = true;
        for (Map.Entry<City, Integer> entry : routes.entrySet()) {
            if (!first) sb.append(", ");
            sb.append(entry.getKey().getName()).append(":").append(entry.getValue());
            first = false;
        }
        return sb.toString();
    }
}