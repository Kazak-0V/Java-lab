package ru.Kazakov.task1a;

class Storage<T> {
    private final T value;
    private final T alternative;

    public Storage(T value, T alternative) {
        this.value = value;
        this.alternative = alternative;
    }

    public T get() {
        if (value == null) {
            return alternative;
        }
        return value;
    }

    @Override
    public String toString() {
        return "Хранилище: " + get();
    }
}