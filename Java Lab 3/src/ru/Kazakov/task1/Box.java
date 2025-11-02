package ru.Kazakov.task1;

class Box<T> {
    private T content;

    public Box() {
        this.content = null;
    }

    public void put(T item) {
        if (!isEmpty()) {  // если не пуста, значит заполнена
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.content = item;
    }

    public T take() {
        if (isEmpty()) { // если пуста, значит не заполнена
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
        if (isEmpty()) {
            return "Коробка пуста";
        } else {
            return "Коробка содержит: " + content;
        }
    }
}