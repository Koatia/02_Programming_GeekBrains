import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_6_1_7 {
    /*
    https://stepik.org/lesson/1082068/step/7?unit=1092346

    У вас есть переменная data, которая содержит входные пользовательские данные.
    data - список из элементов целых чисел.
    Напишите код, который сортирует числовые элементы списка data в порядке возрастания
    и записывает результат через запятую в переменную result.
    Sample Input:
    [1, 3, 2, 4, 5]
    Sample Output:
    1, 2, 3, 4, 5
     */

    public static void main(String[] args) {
        List<Integer> data = readInput();
        String result;
        Collections.sort(data);
        result = data.toString();
        result = result.substring(1, result.length() - 1);

        System.out.println(result);
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            Gson gson = new Gson();
            Integer[] dataArray = gson.fromJson(input, Integer[].class);
            return Arrays.asList(dataArray);
        }
        scanner.close();
        return null;
    }
}