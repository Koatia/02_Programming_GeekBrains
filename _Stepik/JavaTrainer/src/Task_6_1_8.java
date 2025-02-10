import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_6_1_8 {
    /*
    https://stepik.org/lesson/1082068/step/8?unit=1092346

    У вас есть переменная data, которая содержит входные пользовательские данные.
    data - список из элементов целых чисел.
    Напишите код, который сортирует числовые элементы списка data в порядке возрастания,
    отсеивает дубликаты и записывает результат через запятую в переменную result.
    Sample Input:
    [1, 1, 3, 2, 4, 5, 2, 3]
    Sample Output:
    1, 2, 3, 4, 5`
     */

    public static void main(String[] args) {
        List<Integer> data = readInput();
        String result;

        Collections.sort(data);
        result = data.get(0).toString();

        for (int i = 1; i < data.size(); i++) {
            if (!data.get(i - 1).toString().equals(data.get(i).toString())) {
                result += ", ";
                result += data.get(i);
            }
        }

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