import service.Pair;
import com.google.gson.Gson;

import java.util.List;
import java.util.Scanner;

public class Task_6_2_8 {
    /*
    https://stepik.org/lesson/1134286/step/8?unit=1145915

    У вас есть переменные n и items, которые содержат входные пользовательские данные.
    items - список из элементов типа данных Int.
    Напишите код, который копирует элементы списка items из начала списка в конец списка и записывается результат в переменную result.
    n - число элементов которые необходимо скопировать.
    Sample Input:
    2 | [1, 2, 3]
    Sample Output:
    1, 2, 3, 1, 2
     */

    public static void main(String[] args) {
        Pair<Integer, List<Integer>> input = readInput();
        int n = input.getFirst();
        List<Integer> data = input.getSecond();
        String result = copyItems(n, data);
        System.out.println(result);
    }

    public static String copyItems(int n, List<Integer> items) {
        items.addAll(items.subList(0, n)); // добавляем элементы из начала списка в конец списка

        return items.toString().substring(1, items.toString().length() - 1);
    }

    public static Pair<Integer, List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] values = input.split(" \\| ");
        int n = Integer.parseInt(values[0]);
        List<Integer> data = new Gson().fromJson(values[1], new com.google.gson.reflect.TypeToken<List<Integer>>() {
        }.getType());

        return new Pair<>(n, data);
    }
}