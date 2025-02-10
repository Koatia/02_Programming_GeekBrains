import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class Task_6_1_5 {
    /*
    https://stepik.org/lesson/1082068/step/5?unit=1092346

    У вас есть переменная data, которая содержит входные пользовательские данные.
    data - список из элементов строк.
    Напишите код, который обращает порядок следования элементов списке data и записывает результат через запятую в переменную result.
    Sample Input:
    ["Макс", "Дастин", "Майк", "Стив", "Билли"]
    Sample Output:
    Билли, Стив, Майк, Дастин, Макс
     */

    public static void main(String[] args) {
        List<String> data = readInput();
        String result;

        result = data.get(data.size() - 1);
        if (data.size() > 1) {
            for (int i = data.size() - 2; i >= 0; i--) {
                result += ", " + data.get(i);
            }
        }

        System.out.println(result);
    }

    public static List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            Gson gson = new Gson();
            String[] dataArray = gson.fromJson(input, String[].class);
            return Arrays.asList(dataArray);
        }
        scanner.close();
        return null;
    }
}