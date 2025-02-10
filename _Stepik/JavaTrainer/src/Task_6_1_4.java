import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import service.InputData;

import java.util.List;
import java.util.Scanner;

public class Task_6_1_4 {
    /*
    https://stepik.org/lesson/1082068/step/4?unit=1092346

    У вас есть переменные num, data которые содержат входные пользовательские данные.
    data - список из элементов целых чисел.
    Напишите код, который определяет все ли числа в списке data меньше num и записывает логический результат в переменную result.
    Sample Input 1:
    10 | [2, 3]
    Sample Output 1:
    true
    Sample Input 2:
    10 | [2, 3, 15]
    Sample Output 2:
    false
     */

    public static void main(String[] args) {
        InputData inputData = readInput();
        int num = inputData.getNum();
        boolean result = true;
        List<Integer> data = inputData.getData();

        for (int i : data) {
            if (i > num) {
                result = false;
                break;
            }
        }

        System.out.println(result);
    }

    public static InputData readInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            String[] values = input.split(" \\| ");
            int num = Integer.parseInt(values[0]);
            String json = values[1];
            Gson gson = new Gson();
            List<Integer> data = gson.fromJson(json, new TypeToken<List<Integer>>() {
            }.getType());
            return new InputData(num, data);
        }
        scanner.close();
        return null;
    }
}