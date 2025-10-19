import java.util.ArrayList;
import java.util.List;

class City {
    private String name;
    private List<Path> paths;

    public City(String name) {
        this.name = name;
        this.paths = new ArrayList<>();
    }

    public City(String name, List<Path> initialPaths) { // Новый конструктор из задачи 4.8
        this.name = name;
        this.paths = new ArrayList<>(initialPaths);
    }

    public String getName() {
        return name;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void addPath(City city, int cost) {
        paths.add(new Path(city, cost));
    }

    public void addPaths(List<Path> newPaths) { // Новый метод из задачи 4.8
        paths.addAll(newPaths);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Из ").append(name).append(": ");
        if (paths.isEmpty()) {
            sb.append("нет путей");
        } else {
            for (int i = 0; i < paths.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(paths.get(i).getCity().getName())
                        .append(" - ").append(paths.get(i).getCost());
            }
        }
        return sb.toString();
    }
}
