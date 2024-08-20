import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//📌 Заполнить список десятью случайными числами.
//📌 Отсортировать список методом sort() класса Collections и вывести его на экран.

public class RandomArray {
    public static void main(String[] args) {
        List<Integer> list = getNumList();

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }

    private static List<Integer> getNumList() {
        List<Integer> list = new ArrayList<>();
        int sise = 10;
        Random rnd = new Random();
        for (int i = 0; i < sise; i++) {
            list.add(rnd.nextInt(100));
        }
        return list;
    }
}