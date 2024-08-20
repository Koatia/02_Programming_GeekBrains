import com.google.gson.Gson;
import service.Triple;

import java.util.*;

public class Task_6_2_10 {
    /*
    https://stepik.org/lesson/1134286/step/10?unit=1145915

    У вас есть переменныe size, position, data, которые содержат входные пользовательские данные.
    data - список из элементов целых чисел.
    Напишите код, который заполняет список data до нужного размера size нулями 0 в зависимости от значения position,
    которое может принимать значения: left или right.

    Важно!
    Если размер списка data  больше размера size, тогда в переменную result записываем сообщение:
    Неверный размер
    Если размер списка data  равен значению переменной size, тогда в переменную result записываем:
    Массив data в виде строки через запятую.
    Если значение переменной position не равно left или right, тогда в переменную result записываем сообщение:
    Неверная позиция
    Сначала проверяем на корректность позиции, затем на корректность размера.
    Результат записать в виде строки через запятую в переменную result

    Sample Input 1:
    5 | right | [1, 2, 3]
    5 | left | [1, 2, 3]
    Sample Output 1:
    0, 0, 1, 2, 3
    Sample Input 2:
    5 | right | [1, 2, 3, 4, 5]
    Sample Output 2:
    1, 2, 3, 4, 5
    Sample Input 3:
    2 | right | [1, 2, 3, 4, 5]
    Sample Output 3:
    Неверный размер
    Sample Input 4:
    7 | center | [1, 2, 3, 4, 5, 6, 7]
    Sample Output 4:
    Неверная позиция
     */

    public static void main(String[] args) {
        Triple<Integer, String, List<Integer>> input = readInput();
        int size = input.getFirst();
        String position = input.getSecond();
        List<Integer> data = input.getThird();
        String result = fillArray(size, position, data);
        System.out.println(result);
    }

    public static String fillArray(int size, String position, List<Integer> data) {
        int zerosCount = size - data.size(); // количество нулей в переменной data

        if (!position.equals("left") && !position.equals("right")) return "Неверная позиция";

        if (zerosCount < 0) return "Неверный размер";

        if (zerosCount > 0) {
            if (position.equals("left")) data.addAll(0, Collections.nCopies(zerosCount, 0));
            else data.addAll(Collections.nCopies(zerosCount, 0));
        }

        return data.toString().substring(1, data.toString().length() - 1);
    }

    public static Triple<Integer, String, List<Integer>> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] values = input.split(" \\| ");
        int size = Integer.parseInt(values[0]);
        String position = values[1];
        List<Integer> data = new Gson().fromJson(values[2], new com.google.gson.reflect.TypeToken<List<Integer>>() {
        }.getType());

        return new Triple<>(size, position, data);
    }
}