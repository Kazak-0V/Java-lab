package ru.Kazakov.task5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Звонкие согласные в тексте");
        String file = "text.txt";
        List<Character> result = ConsonantProcessor.findConsonants(file);
        ConsonantProcessor.printResult(result);

        System.out.println("\nЗвонкие согласные: б, в, г, д, ж, з, й, л, м, н, р");
    }
}