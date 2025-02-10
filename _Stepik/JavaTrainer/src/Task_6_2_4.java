import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

import service.Pair;

public class Task_6_2_4 {
    /*
    https://stepik.org/lesson/1134286/step/4?unit=1145915

    У вас есть переменные n и items, которые содержат входные пользовательские данные.
    items - список из элементов целых чисел.
    Напишите код, который перемещает элементы списка items из начала массива в конец списка и записывается результат в переменную result.
    n - число элементов которые необходимо переместить.

    Sample Input:
    3 | [1, 3, 2, 5, 9, 8, 1, 2]
    Sample Output:
    5, 9, 8, 1, 2, 1, 3, 2
     */

    public static void main(String[] args) {
        Pair<Integer, List<Integer>> input = readInput();
        int n = input.getFirst();
        List<Integer> data = input.getSecond();
        String result = moveItems(n, data);
        System.out.println(result);
    }

    public static String moveItems(int n, List<Integer> items) {
        for (int i = 0; i < n; i++) {
            items.add(items.get(0));
            items.remove(0);
        }

        String result = items.toString();
        return result.substring(1, result.length() - 1); // remove first and last char
    }

    public static Pair<Integer, List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Integer>>() {
        }.getType();
        List<Integer> data = gson.fromJson(input.split(" \\| ")[1], listType);
        int n = Integer.parseInt(input.split(" \\| ")[0]);

        return new Pair<>(n, data);
    }
}