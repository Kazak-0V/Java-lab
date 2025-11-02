package ru.Kazakov.task1;

public class Main {

    private static void showValueFromBox(Box<Integer> box) {
        Integer value = box.take();
        System.out.println("Извлекли значение: " + value);
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();

        // Размещаем число 3 как сказано в задании
        box.put(3);
        System.out.println(box);

        // Передаем коробку в метод и извлекаем значение
        showValueFromBox(box);

        // Показываем что коробка пуста
        System.out.println("После извлечения: " + box);
    }
}