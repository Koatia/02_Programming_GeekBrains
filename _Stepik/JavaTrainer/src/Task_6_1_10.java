import com.google.gson.*;

import java.util.*;

public class Task_6_1_10 {
    /*
    https://stepik.org/lesson/1082068/step/10?unit=1092346

    У вас есть переменная tags, которая содержит входные пользовательские данные.
    tags - список из элементов строк.
    Напишите код, который считает количество тегов в списке tags и записывает отсортированный результат в том порядке в котором теги были найдены через запятую в переменную result.
    Sample Input:
    ["action", "adventure", "strategy", "simulation", "sports", "racing", "puzzle", "strategy", "simulation", "sports"]
    Sample Output:
    action: 1, adventure: 1, strategy: 2, simulation: 2, sports: 2, racing: 1, puzzle: 1
     */

    public static void main(String[] args) {
        ArrayList<String> tags = readInput();
        String result = "";

        int count = 1;
        for (int i = 0; i < tags.size(); i++) {
            for (int j = tags.size() - 1; j > i; j--) {
                if (tags.get(i).equals(tags.get(j))) {
                    count++;
                    tags.remove(j);
                }
            }
            result += tags.get(i) + ": " + count;
            if (i != tags.size() - 1) result += ", ";
            count = 1;
        }

        System.out.println(result);
    }

    public static ArrayList<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            Gson gson = new Gson();
            String[] dataArray = gson.fromJson(input, String[].class);
            return new ArrayList<>(Arrays.asList(dataArray));
        }
        scanner.close();
        return null;
    }
}