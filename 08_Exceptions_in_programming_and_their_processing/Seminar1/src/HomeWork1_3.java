import java.util.Arrays;

/*
Реализуйте метод subArrays, принимающий в качестве аргументов два целочисленных массива a и b, и возвращающий новый массив c,
 каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны - верните нулевой массив длины 1.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.

Напишите свой код в методе divArrays класса Answer. Метод divArrays принимает на вход два параметра:
int[] a - первый массив
int[] b - второй массив
*/
public class HomeWork1_3 {
    public static void main(String[] args) {
        int[] a = {12, 8, 16};
        int[] b = {4, 2, 4};
        int[] c = divArrays(a, b);
        System.out.println(Arrays.toString(c));
    }

    public static int[] divArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return new int[]{0};
        }
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0) {
                throw new RuntimeException("Деление на 0");
            }
            c[i] = a[i] / b[i];
        }
        return c;
    }
}