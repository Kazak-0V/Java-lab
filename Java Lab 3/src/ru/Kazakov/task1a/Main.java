package ru.Kazakov.task1a;

public class Main {

    private static void processNumberStorage(Storage<Integer> storage) {
        Integer value = storage.get();
        System.out.println("Из хранилища чисел: " + value);
    }

    private static void processStringStorage(Storage<String> storage) {
        String value = storage.get();
        System.out.println("Из хранилища строк: " + value);
    }

    public static void main(String[] args) {
        // 1. Хранилище чисел с null (альтернатива 0)
        Storage<Integer> numberStorage1 = new Storage<>(null, 0);
        System.out.println(numberStorage1);
        processNumberStorage(numberStorage1);

        // 2. Хранилище чисел с 99 (альтернатива -1)
        Storage<Integer> numberStorage2 = new Storage<>(99, -1);
        System.out.println(numberStorage2);
        processNumberStorage(numberStorage2);

        // 3. Хранилище строк с null (альтернатива "default")
        Storage<String> stringStorage1 = new Storage<>(null, "default");
        System.out.println(stringStorage1);
        processStringStorage(stringStorage1);

        // 4. Хранилище строк с "hello" (альтернатива "hello world")
        Storage<String> stringStorage2 = new Storage<>("hello", "hello world");
        System.out.println(stringStorage2);
        processStringStorage(stringStorage2);
    }
}