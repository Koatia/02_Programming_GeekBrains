import java.util.*;
import java.util.stream.Collectors;

// Напишите код, который считает количество тегов в списке tags
// и записывает отсортированный результат в том порядке, в котором теги были найдены через запятую в переменную result.

public class SortedAndUniqueCountList {
    public static void main(String[] args) {
        ArrayList<String> tags = readInput();
        String result = "";

        // Первый вариант
        // int count = 1;
        // for (int i = 0; i < tags.size(); i++) {
        // for (int j = tags.size() - 1; j > i; j--) {
        // if (tags.get(i).equals(tags.get(j))) {
        // count++;
        // tags.remove(j);
        // }
        // }
        // result += tags.get(i) + ": " + count;
        // if (i != tags.size() - 1) result += ", ";
        // count = 1;
        // }

        // Второй вариант
        Map<String, Integer> dict = new LinkedHashMap();

        tags.stream()
                .forEach(key -> {
                    dict.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
                });

        result = dict.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    public static ArrayList<String> readInput() {
        ArrayList<String> arrList = new ArrayList<>(Arrays.asList("action", "adventure", "strategy", "simulation",
                "sports", "racing", "puzzle", "strategy", "simulation", "sports"));
        return arrList;
    }
}