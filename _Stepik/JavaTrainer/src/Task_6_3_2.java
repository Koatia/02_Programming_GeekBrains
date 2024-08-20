import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Scanner;

public class Task_6_3_2 {
    /*
    https://stepik.org/lesson/1247902/step/2?unit=1261747

    У вас есть переменная data которая содержит входные пользовательские данные.
    data - список из элементов строки.
    Напишите код, который проходит по массиву data,
    и записывает символы вместе с числом их повторений в переменную result
    Sample Input:
    ["a", "a", "a", "b", "b", "c", "c", "a", "a", "a"]
    Sample Output:
    a3b2c2a3

     */

    public static void main(String[] args) {
        List<String> data = readInput();

        StringBuilder result = new StringBuilder();
        String current = data.getFirst();
        int count = 1;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).equals(current)) {
                count++;
            } else {
                result.append(current).append(count);
                count = 1;
                current = data.get(i);
            }
        }
        result.append(current).append(count);

        System.out.println(result);

    }

    public static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<String>>() {
        }.getType());
    }
}