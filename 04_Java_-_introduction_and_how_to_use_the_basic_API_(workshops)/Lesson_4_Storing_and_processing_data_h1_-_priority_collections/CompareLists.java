// 1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.

// 2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.

import java.util.ArrayList;
import java.util.LinkedList;

public class CompareLists {
    public static void main(String[] args) {
        int size = 100_000;

        System.out.println("Добавление в конец списка");
        long start = System.currentTimeMillis();
        getArrayListAddLast(size);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        getLinkedListAddLast(size);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println();

        System.out.println("Добавление в начало списка");
        start = System.currentTimeMillis();
        getArrayListAddFirst(size);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        getLinkedListAddFirst(size);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println();

        System.out.println("Добавление в середину списка");
        start = System.currentTimeMillis();
        getArrayListAddMiddle(size);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        getLinkedListAddMiddle(size);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static ArrayList<Integer> getArrayListAddLast(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.addLast(i);
        }
        return arrayList;
    }

    public static LinkedList<Integer> getLinkedListAddLast(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.addLast(i);
        }
        return linkedList;
    }

    public static ArrayList<Integer> getArrayListAddFirst(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.addFirst(i);
        }
        return arrayList;
    }

    public static LinkedList<Integer> getLinkedListAddFirst(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.addFirst(i);
        }
        return linkedList;
    }

    public static ArrayList<Integer> getArrayListAddMiddle(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        return arrayList;
    }

    public static LinkedList<Integer> getLinkedListAddMiddle(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(linkedList.size() / 2, i);
        }
        return linkedList;
    }

}
