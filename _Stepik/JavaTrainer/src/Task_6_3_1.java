import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class Task_6_3_1 {
    /*
    https://stepik.org/lesson/1247902/step/1?unit=1261747

    У вас есть переменная data которая содержит входные пользовательские данные.
    data - список из элементов целых чисел.
    Напишите код, который проходит по списку data, удаляет все нулевые элементы массива и записывает новый список в переменную result.
    Sample Input:
    [0,1,0,1,1,1,0,1]
    Sample Output:
    [1,1,1,1,1]

     */

    public static void main(String[] args) {
        List<Integer> data = readInput();
        List<Integer> result = deleteZeroValues(data);
        System.out.println(new Gson().toJson(result));
    }

    public static List<Integer> deleteZeroValues(List<Integer> data) {
        List<Integer> result = new ArrayList<>();
        for (Integer datum : data) {
            if (datum != 0) {
                result.add(datum);
            }
        }
        return result;
    }

    public static List<Integer> readInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Gson().fromJson(input, new TypeToken<List<Integer>>() {
        }.getType());
    }
}