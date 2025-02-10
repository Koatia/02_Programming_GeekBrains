import com.google.gson.Gson;

import java.util.*;

import service.Pair;

public class Task_6_2_11 {
    /*
    https://stepik.org/lesson/1134286/step/11?unit=1145915

    У вас есть переменные k, data которые содержат входные пользовательские данные.
    data - двумерный список из элементов целых чисел.
    Напишите код, который находит число k в двумерном в списке data и записывает логический результат в переменную result.
    Пример двумерного списка:
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ]
    Важно!
    Список data может быть любого размера.
    Sample Input 1:
    5 | [[1,2,3],[4,5,6],[7,8,9]]
    Sample Output 1:
    true
    Sample Input 2:
    0 | [[1,2,3],[4,5,6],[7,8,9]]
    Sample Output 2:
    false
     */

    public static void main(String[] args) {
        Pair<Integer, List<List<Integer>>> input = readInput();
        int k = input.getFirst();
        List<List<Integer>> data = input.getSecond();
        boolean result = findNumber(k, data);
        System.out.println(result);
    }

    public static boolean findNumber(int k, List<List<Integer>> data) {
        for (List<Integer> list : data) {
            if (list.contains(k)) return true;
        }
        return false;
    }

    public static Pair<Integer, List<List<Integer>>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] values = input.split(" \\| ");
        int k = Integer.parseInt(values[0]);
        List<List<Integer>> data = new Gson().fromJson(values[1], new com.google.gson.reflect.TypeToken<List<List<Integer>>>() {
        }.getType());

        return new Pair<>(k, data);
    }
}