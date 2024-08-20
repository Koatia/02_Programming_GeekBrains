import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

//Напишите код, который сортирует числовые элементы списка data в порядке возрастания,
// отсеивает дубликаты и записывает результат через запятую в переменную result

public class SortedAndUniqueList2 {
    public static void main(String[] args) {
        ArrayList<String> tags = readInput();
        String result;

        result = tags.stream()
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    public static ArrayList<String> readInput() {
        ArrayList<String> d = new ArrayList<>(Arrays.asList("action", "adventure", "strategy", "simulation", "sports",
                "racing", "puzzle", "strategy", "simulation", "sports"));
        return d;
    }
}