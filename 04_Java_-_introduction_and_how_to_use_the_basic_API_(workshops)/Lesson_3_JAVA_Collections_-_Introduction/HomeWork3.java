import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Реализуйте метод, который принимает на вход целочисленный массив arr:
//        - Создаёт список ArrayList, заполненный числами из исходого массива arr.
//        - Сортирует список по возрастанию и выводит на экран.
//        - Находит минимальное значение в списке и выводит на экран - Minimum is {число}
//        - Находит максимальное значение в списке и выводит на экран - Maximum is {число}
//        - Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
//Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:
//Integer[] arr - массив целых чисел.
class Answer3 {
    public static void analyzeNumbers(Integer[] arr) {
        // Введите свое решение ниже
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(arrList);
        double averege = 0.0;
        for (int i : arrList)
            averege += i;

        System.out.println(arrList);
        System.out.printf("Minimum is %d%n", arrList.get(0));
        System.out.printf("Maximum is %d%n", arrList.get(arrList.size() - 1));
        System.out.printf("Average is = %.1f", averege / arrList.size());
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки

public class HomeWork3 {
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
        } else {
            arr = Arrays.stream(args[0].split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
        }

        Answer3 ans = new Answer3();
        ans.analyzeNumbers(arr);
    }
}