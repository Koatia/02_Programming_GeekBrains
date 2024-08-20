import com.google.gson.*;

import java.util.*;

public class Task_6_1_9 {
    /*
    https://stepik.org/lesson/1082068/step/9?unit=1092346

    У вас есть переменная tags, которая содержит входные пользовательские данные.
    tags - список из элементов строк.
    Напишите код, который сортирует строковые элементы списка tags в порядке возрастания, отсеивает дубликаты и записывает результат через запятую в переменную result.
    Sample Input:
    ["action", "adventure", "strategy", "simulation", "sports", "racing", "puzzle", "strategy", "simulation", "sports"]
    Sample Output:
    action, adventure, puzzle, racing, simulation, sports, strategy
     */

    public static void main(String[] args) {
        List<String> tags = readInput();
        String result;

        TreeSet uniqueData = new TreeSet(tags);
        result = uniqueData.toString();
        result = result.substring(1, result.length() - 1);

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