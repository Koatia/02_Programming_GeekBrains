import service.Pair;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_6_2_6 {
    /*
    https://stepik.org/lesson/1134286/step/6?unit=1145915

    У вас есть переменные health и items, которые содержат входные пользовательские данные.
    items - список из элементов строк.
    Напишите код, который увеличивает значение переменной health в зависимости от того, сколько зелья находится в списке items
    и записывается результат в переменную result.

    Важно!
    Одно "Зелье" это +10 к health
    Итоговое значение переменной result не должно быть больше 100. Если значение переменной result получается больше 100,
    тогда устанавливаем значении переменной result равной 100.
    Sample Input 1:
    70 | ["Меч", "Щит", "Свиток", "Зелье"]
    Sample Output 1:
    80
     */

    public static void main(String[] args) {
        Pair<Integer, List<String>> input = readInput();
        int power = input.getFirst();
        List<String> items = input.getSecond();
        int result = increasePower(power, items);
        System.out.println(result);
    }

    public static int increasePower(int power, List<String> items) {
        power += 10 * Collections.frequency(items, "Зелье");

        return Math.min(power, 100);
    }

    public static Pair<Integer, List<String>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        List<String> items = gson.fromJson(input.split(" \\| ")[1], listType);
        int power = Integer.parseInt(input.split(" \\| ")[0]);

        return new Pair<>(power, items);
    }
}