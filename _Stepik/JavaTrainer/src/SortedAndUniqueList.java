import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

//Напишите код, который сортирует числовые элементы списка data в порядке возрастания,
// отсеивает дубликаты и записывает результат через запятую в переменную result

public class SortedAndUniqueList {
    public static void main(String[] args) {
        ArrayList<Integer> data = readInput();
        String result;

        TreeSet<Integer> uniqueData = new TreeSet<>(data);
        result = uniqueData.toString();
        result = result.substring(1, result.length() - 1);

        System.out.println(result);
    }

    public static ArrayList<Integer> readInput() {
        ArrayList<Integer> d = new ArrayList<>(Arrays.asList(1, 1, 3, 2, 4, 5, 2, 3));
        return d;
    }
}