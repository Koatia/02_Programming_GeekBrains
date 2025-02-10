import java.util.Scanner;

public class Task_5_1_1 {
    /*
    https://stepik.org/lesson/1246037/step/1?unit=1259855

    У вас есть переменная n которая содержит входные пользовательские данные.
    n - положительное целое число
    У вас есть положительное целое число n, представляющее количество шляп и количество людей. Нужно определить общее количество способов, которыми n шляп можно вернуть n людям таким образом, что ни одна шляпа не возвращается к своему владельцу (т.е., ни один человек не получает свою собственную шляпу).
    Эта задача известна как "проблема шляпного чека" или "проблема нарушения перестановок".
    Ответ на эту задачу представляет собой количество !n нарушений n-элементного набора.
    Нарушение — это такая перестановка элементов множества, при которой ни один элемент не появляется в исходном положении.
    Результат записать в виде числа в переменную result.
    Sample Input 1:
    2
    Sample Output 1:
    1
    Sample Input 2:
    3
    Sample Output 2:
    2
     */

    public static void main(String[] args) {
        int n = readInput();
        int result;

        result = f(n);

        System.out.println(result);
    }

    public static int f(int n) {
        if (n == 1 || n == 2) {
            return n - 1;
        }
        return (n - 1) * (f(n - 1) + f(n - 2));
    }

    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}