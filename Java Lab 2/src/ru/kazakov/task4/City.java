package ru.kazakov.task4;

import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> routes;

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public void addRoute(City city, int cost) {
        routes.put(city, cost);
    }

    public String getName() {
        return name;
    }

    public Map<City, Integer> getRoutes() {
        return routes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ");

        boolean first = true;
        for (Map.Entry<City, Integer> entry : routes.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey().getName())
                    .append(":")
                    .append(entry.getValue());
            first = false;
        }

        return sb.toString();
    }
}