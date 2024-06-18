import java.util.Scanner;

public class Task_5_1_5 {
    /*
    https://stepik.org/lesson/1246037/step/5?unit=1259855

    У вас есть переменная n которая содержит входные пользовательские данные.
    Напишите код, который определяет, есть ли у числа n брэйк-пойнт.
    "брэйк-пойнтом" называется такая точка в числе, при которой число можно разделить на две "равные" части,
    где сумма чисел слева и справа от этой точки равна.
    Например, число 35190 можно разделить на 351 и 90, потому что 3 + 5 + 1 = 9 и 9 + 0 = 9.
    А например у числа 555 такого брэйк-пойнта нет, так как оно нельзя разделить на две равные части.
    Логический результат записать в переменную result.

    Важно!
    Каждая цифра числа является отдельным числом для целей данной задачи.
    Например, число 123 = 1 + 2 + 3, а не 123 = 1 + 23 или 123 = 12 + 3.
    Sample Input 1:
    159780
    Sample Output 1:
    true
    Sample Input 2:
    112
    Sample Output 2:
    true
    Sample Input 3:
    10
    Sample Output 3:
    false
     */

    public static void main(String[] args) {
        int n = readInput();
        boolean result = false;

        result = breakPoint(n);
        System.out.println(result);
    }

    public static Boolean breakPoint(int n) {
        String str = Integer.toString(n);
        int iLeft = 0;
        int left = Character.getNumericValue(str.charAt(iLeft));
        int iRight = str.length() - 1;
        int right = Character.getNumericValue(str.charAt(iRight));

        while (iLeft < iRight - 1) {
            if (left <= right) {
                left += (Character.getNumericValue(str.charAt(++iLeft)));
            } else right += (Character.getNumericValue(str.charAt(--iRight)));
        }
        return left == right;
    }

    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}