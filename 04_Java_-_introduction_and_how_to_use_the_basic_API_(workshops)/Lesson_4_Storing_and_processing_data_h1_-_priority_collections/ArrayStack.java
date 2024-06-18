// ; Реализовать стэк с помощью массива.
// ; Нужно реализовать методы:
// ; size(), empty(), push(), peek(), pop().

public class ArrayStack {
    static int capacity;
    static int[] array;
    static int topIndex;

    public static void main(String[] args) {
        capacity = 5;
        array = new int[5];
        topIndex = -1;
        System.out.println(size()); // 0
        System.out.println(empty()); // true
        push(5);
        push(10);
        push(20);
        push(15);
        System.out.println(empty());  // false
        System.out.println(size()); // 4
        System.err.println(pop()); // 15
        System.out.println(size()); // 3
        System.out.println(peek()); // 20 
    }

    public static int size() {
        return topIndex + 1;
    }

    public static boolean empty() {
        return topIndex == -1;
    }

    public static void push(int element) {
        array[++topIndex] = element;
        // array[topIndex + 1] = element;
        // topIndex++;
    }

    public static int peek() {
        return array[topIndex];
    }

    public static int pop() {
        return array[topIndex--];
    }

}