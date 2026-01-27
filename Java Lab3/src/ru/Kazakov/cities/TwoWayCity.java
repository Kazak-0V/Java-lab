package ru.Kazakov.cities;


public class TwoWayCity extends City {

    public TwoWayCity(String name) {
        super(name);
    }

    @Override
    public void addRoute(City otherCity, int cost) {
        // Вызываем родительский метод для добавления дороги
        super.addRoute(otherCity, cost);

        // Добавляем обратную дорогу, если её ещё нет
        if (!otherCity.hasRouteTo(this)) {
            addReverseRoute(otherCity, cost);
        }
    }

    private void addReverseRoute(City otherCity, int cost) {
        try {
            if (otherCity instanceof TwoWayCity) {
                TwoWayCity otherTwoWay = (TwoWayCity) otherCity;
                otherTwoWay.superAddRoute(this, cost);
            } else {
                otherCity.addRoute(this, cost);
            }
        } catch (IllegalStateException e) {
            // Если дорога уже существует, просто обновляем стоимость
            otherCity.updateRoute(this, cost);
        }
    }

    void superAddRoute(City city, int cost) {
        super.addRoute(city, cost);
    }

    @Override
    public String toString() {
        return "[Двусторонний] " + super.toString();
    }
}