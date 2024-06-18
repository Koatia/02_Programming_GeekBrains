import java.util.Scanner;

public class Task_6_3_3 {
    /*
    https://stepik.org/lesson/1247902/step/3?unit=1261747

    У вас есть переменная message которая содержит входные пользовательские данные.
    Напишите код, который:
    Читает строку message  вида: a2b3c1
    Воссоздает массив: a2b3c1 -> ["a","a","b","b","b","c"]
    Записывает воссозданный массив через запятую в переменную result.
    Sample Input:
    a2b3c1
    Sample Output:
    a, a, b, b, b, c

     */

    public static void main(String[] args) {
        String message = readInput();
        StringBuilder result = new StringBuilder();

        System.out.println(result);
    }

    public static String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}