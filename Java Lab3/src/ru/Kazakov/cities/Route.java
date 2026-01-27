package ru.Kazakov.cities;


import java.util.*;


public class Route {
    private City start;
    private City end;

    public Route(City start, City end) {
        if (start == null || end == null) {
            throw new IllegalArgumentException("Города начала и конца не могут быть null");
        }
        this.start = start;
        this.end = end;
    }

    public City getStart() {
        return start;
    }

    public City getEnd() {
        return end;
    }

    public void setStart(City start) {
        if (start == null) {
            throw new IllegalArgumentException("Город начала не может быть null");
        }
        this.start = start;
    }

    public void setEnd(City end) {
        if (end == null) {
            throw new IllegalArgumentException("Город конца не может быть null");
        }
        this.end = end;
    }

    public City[] getPath() {
        if (start.equals(end)) {
            return new City[]{start};
        }

        Map<City, City> parentMap = new HashMap<>();
        Queue<City> queue = new LinkedList<>();
        Set<City> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        parentMap.put(start, null);

        while (!queue.isEmpty()) {
            City current = queue.poll();
            Map<City, Integer> neighbors = current.getRoutes();

            for (City neighbor : neighbors.keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);

                    if (neighbor.equals(end)) {
                        return reconstructPath(parentMap);
                    }
                }
            }
        }

        return new City[0];
    }

    private City[] reconstructPath(Map<City, City> parentMap) {
        List<City> path = new ArrayList<>();
        City current = end;

        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }

        Collections.reverse(path);
        return path.toArray(new City[0]);
    }

    @Override
    public String toString() {
        City[] path = getPath();
        if (path.length == 0) {
            return "Маршрут из " + start.getName() + " в " + end.getName() + " не найден";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length; i++) {
            sb.append(path[i].getName());
            if (i < path.length - 1) {
                sb.append(" → ");
            }
        }
        return sb.toString();
    }
}