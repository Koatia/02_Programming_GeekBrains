import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//Дан произвольный массив целых чисел. Создайте список ArrayList, заполненный данными из этого массива.
//Необходимо удалить из списка четные числа и вернуть результирующий.
//Напишите свой код в методе removeEvenNumbers класса Answer. Метод removeEvenNumbers принимает на вход один параметр:
//Integer[] arr - список целых чисел, возвращает список ArrayList<Integer>

class Answer {
    public static void removeEvenNumbers(Integer[] arr) {
        // Введите свое решение ниже
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arr));

        Iterator<Integer> iterator = arrList.iterator();
        while (iterator.hasNext()) {
            Integer elem = iterator.next();
            if (elem % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(arrList);

    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class HomeWork2 {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        } else {
            arr = Arrays.stream(args[0].split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.removeEvenNumbers(arr);
    }
}