package ru.Kazakov.task2;

class Box<T> {
    private T content;

    public Box() {
        this.content = null;
    }

    public void put(T item) {
        if (!isEmpty()) {
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.content = item;
    }

    public T take() {
        if (isEmpty()) {
            throw new IllegalStateException("Коробка пуста!");
        }
        T item = content;
        content = null;
        return item;
    }

    public boolean isEmpty() {
        return content == null;
    }

    @Override
    public String toString() {
        return isEmpty() ? "Коробка пуста" : "Коробка содержит: " + content;
    }
}