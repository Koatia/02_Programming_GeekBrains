import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

import static java.lang.System.in;

public class Task_6_2_1 {
    /*
    https://stepik.org/lesson/1134286/step/1?unit=1145915

    У вас есть переменная data, которая содержит входные пользовательские данные.
    data - список из элементов целых чисел.
    Напишите код, который будет находить четные и нечетные числа и записывать результат в виде строки:
    (четные) (нечетные) в переменную result.
    Важно! Четные и нечетные числа должны быть отсортированы в порядке возрастания.

    Sample Input:
    [4, 3, 7, 1, 8, 6, 5, 2]
    Sample Output:
    (2, 4, 6, 8) (1, 3, 5, 7)
     */

    public static void main(String[] args) {
//        List<Integer> data = readInput();
        List<Integer> data = Arrays.asList(3, 6, 43, 8, 11, 7, 33, 3, 4, 8);
        String result;

        result = findEvenOddNumbers(data);

        System.out.println(result);
    }

    public static String findEvenOddNumbers(List<Integer> data) {
        Collections.sort(data);

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        for (int i : data) {
            if (i % 2 == 0) {
                res1.add(i);
            } else {
                res2.add(i);
            }
        }

        return "(" + res1.toString().replaceAll("[\\[\\]]", "") + ") (" + res2.toString().replaceAll("[\\[\\]]", "") + ")";
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(in);
        String input = scanner.nextLine();

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Integer>>() {
        }.getType();
        return gson.fromJson(input, listType);
    }
}