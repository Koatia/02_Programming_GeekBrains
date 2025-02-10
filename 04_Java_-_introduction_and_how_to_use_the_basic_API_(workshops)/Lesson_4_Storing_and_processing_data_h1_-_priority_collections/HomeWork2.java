// В классе MyQueue реализуйте очередь для типа данных Integer с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди
// dequeue() - возвращает первый элемент из очереди и удаляет его
// first() - возвращает первый элемент из очереди, не удаляя
// getElements() - возвращает все элементы в очереди

import java.util.LinkedList;

class MyQueue<T> {

    private LinkedList<T> elements = new LinkedList<>();

    public void enqueue(T element) {
        // - помещает элемент в конец очереди
        elements.add(element);
    }

    public T dequeue() {
        // - возвращает первый элемент из очереди и удаляет его
        return elements.removeFirst();
    }

    public T first() {
        // - возвращает первый элемент из очереди, не удаляя
        return elements.getFirst();
    }

    public LinkedList<T> getElements() { // возвращает все элементы в очереди
        // - возвращает все элементы в очереди
        return elements;
    }

}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class HomeWork2 {
    public static void main(String[] args) {
        MyQueue<Integer> queue;
        queue = new MyQueue<>();

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            queue.enqueue(1);
            queue.enqueue(10);
            queue.enqueue(15);
            queue.enqueue(5);
        } else {
            queue.enqueue(Integer.parseInt(args[0]));
            queue.enqueue(Integer.parseInt(args[1]));
            queue.enqueue(Integer.parseInt(args[2]));
            queue.enqueue(Integer.parseInt(args[3]));
        }

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.getElements());

        System.out.println(queue.first());
    }
}