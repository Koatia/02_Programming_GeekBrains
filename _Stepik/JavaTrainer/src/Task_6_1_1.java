import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Scanner;

public class Task_6_1_1 {
    /*
    https://stepik.org/lesson/1082068/step/1?unit=1092346

    У вас есть переменная data, которая содержит входные пользовательские данные.
    data - список из элементов целых чисел.
    Напишите код, который определяет все ли числа в списке data четные и записывает
    логический результат в переменную result.
    Sample Input 1:
    [2, 4, 6, 8, 10]
    Sample Output 1:
    true
    Sample Input 2:
    [1, 4, 6, 8, 10]
    Sample Output 2:
    false
     */

    public static void main(String[] args) {
        List<Integer> data = readInput();
        boolean result = true;
        int count = data.size();

        while (result && count > 0) {
            if (data.get(--count) % 2 != 0)
                result = false;
        }
        System.out.println(result);
    }

    public static List<Integer> readInput() {
        List<Integer> data = null;

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            Gson gson = new Gson();
            data = gson.fromJson(input, new TypeToken<List<Integer>>(){}.getType());
        }
        scanner.close();

        return data;
    }
}