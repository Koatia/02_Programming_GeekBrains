// 1) Написать метод, который принимает массив элементов, помещает их в стэк
// и выводит на консоль содержимое стэка.
// 2) Написать метод, который принимает массив элементов, помещает их в
// очередь и выводит на консоль содержимое очереди.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Stack<Integer> stack = fillPrintStack(arr);
        printStack(stack);
        System.out.println();
        Queue<Integer> queue = fillPrintQueue(arr);
        printQueue(queue);
    }

    private static void printStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void printQueue(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static Stack<Integer> fillPrintStack(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int item : array) {
            stack.push(item); // добавление элементов в стэк
        }
        return stack;
    }

    public static Queue<Integer> fillPrintQueue(int[] array) {
        Queue<Integer> queue = new LinkedList<>();
        for (int item : array) {
            queue.add(item);
        }
        return queue;
    }

}