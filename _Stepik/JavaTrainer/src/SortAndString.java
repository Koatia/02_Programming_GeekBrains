// Напишите код, который сортирует строковые элементы массива data в порядке возрастания
// и записывает результат через запятую в переменную result

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortAndString {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("Макс", "Дастин", "Майк", "Стив", "Билли");
        String result;

        result = SortAndJoin(data);

        System.out.println(result);
    }

    private static String SortAndJoin(List<String> data) {
        Collections.sort(data);
        return String.join(", ", data);
    }
}