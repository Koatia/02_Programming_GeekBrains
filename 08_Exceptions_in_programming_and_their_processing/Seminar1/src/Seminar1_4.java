import java.util.ArrayList;
import java.util.List;

public class Seminar1_4 {
    /*
Задание №4.
Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента
целочисленный одномерный массив.
Метод должен пройтись по каждому элементу и проверить что он не равен null.
А теперь реализуйте следующую логику:
1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом
пользователя
2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их
“подсветить”
 */
    public static void main(String[] args) {
        Integer[] arr = {1, null, 3, null, 5};
        List<Integer> nullElements = checkArray(arr);
        if (nullElements.size() > 0) {
            System.out.println("Null elements in positions: " + nullElements);
        } else {
            System.out.println("No null elements in array");
        }
    }

    public static List<Integer> checkArray(Integer[] arr) {
        List<Integer> nullElements = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                nullElements.add(i);
            }
        }
        return nullElements;
    }
}