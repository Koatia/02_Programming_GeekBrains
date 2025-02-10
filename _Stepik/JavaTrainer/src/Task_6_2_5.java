import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import service.Pair;

import java.lang.reflect.Type;
import java.util.*;

public class Task_6_2_5 {
    /*
    https://stepik.org/lesson/1134286/step/5?unit=1145915

    У вас есть переменные n, data которые содержат входные пользовательские данные.
    data - список из элементов целых чисел.
    Напишите код, который умножает каждый элемент списка на значение переменной n и записывает отсортированный результат в порядке возрастания в виде строки через запятую в переменную result.
    Sample Input:
    2 | [1, 2, 3]
    Sample Output:
    2, 4, 6
     */

    public static void main(String[] args) {
        Pair<Integer, List<Integer>> input = readInput();
        int n = input.getFirst();
        List<Integer> data = input.getSecond();
        String result = multiplyAndSortList(data, n);
        System.out.println(result);
    }

    public static String multiplyAndSortList(List<Integer> data, int n) {
        Collections.sort(data); // сортируем список

        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * n);
        }

        String result = data.toString();
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