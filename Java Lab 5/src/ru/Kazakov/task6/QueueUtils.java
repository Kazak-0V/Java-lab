package ru.Kazakov.task6;

import java.util.Queue;
import java.util.Stack;

public class QueueUtils {

    public static void printQueueReverse(Queue queue) {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста!");
            return;
        }

        System.out.println("Оригинальная очередь: " + queue);
        Stack stack = new Stack();

        // из очереди в стек
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // печать из стека
        System.out.print("Очередь в обратном порядке: [");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}