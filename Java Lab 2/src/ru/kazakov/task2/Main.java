package ru.kazakov.task2;

public class Main {
    public static void main(String[] args) {
        Name name1 = new Name("Клеопатра", null, null);
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name name3 = new Name("Маяковский", "Владимир", null);

        System.out.println("Имя 1: " + name1);
        System.out.println("Имя 2: " + name2);
        System.out.println("Имя 3: " + name3);
    }
}