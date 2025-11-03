package ru.Kazakov.task1;

public class Main {

    private static void showValueFromBox(Box<Integer> box) {
        Integer value = box.take();
        System.out.println("Извлекли значение: " + value);
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();

        box.put(3);
        System.out.println(box);

        showValueFromBox(box);

        System.out.println("После извлечения: " + box);
    }

}
