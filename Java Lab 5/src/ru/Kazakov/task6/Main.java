package ru.Kazakov.task6;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add(10);
        queue.add(23);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        QueueUtils.printQueueReverse(new LinkedList(queue));
        System.out.println("Очередь после обработки: " + queue);
        System.out.println();

        // Пример со строками
        Queue stringQueue = new LinkedList();
        stringQueue.add("яблоко");
        stringQueue.add("банан");
        stringQueue.add("апельсин");

        QueueUtils.printQueueReverse(new LinkedList(stringQueue));
        System.out.println("Очередь после обработки: " + stringQueue);
        System.out.println();

        // Пример с пустой очередью
        Queue emptyQueue = new LinkedList();
        QueueUtils.printQueueReverse(emptyQueue);
    }
}