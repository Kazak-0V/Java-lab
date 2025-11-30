package ru.Kazakov.task2;

public class Main {
    public static void main(String[] args) {
        // Создаем кота
        Cat cat = new Cat("Шайтан");

        // Обертываем в счетчик
        CatCounter counter = new CatCounter(cat);

        // Передаем в метод
        CatCounter[] cats = {counter};
        CatUtils.makeCatsMeow(cats);
        CatUtils.makeCatsMeow(cats);
        CatUtils.makeCatsMeow(cats);

        // Узнаем количество мяуканий
        System.out.println("Кот мяукал: " + counter.getMeowCount() + " раз");
    }
}