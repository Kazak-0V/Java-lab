package ru.Kazakov.task2;

public class CatCounter {
    private Cat cat;
    private int meowCount;

    public CatCounter(Cat cat) {
        this.cat = cat;
        this.meowCount = 0;
    }

    public void meow() {
        cat.meow();
        meowCount++;
    }

    public int getMeowCount() {
        return meowCount;
    }
}