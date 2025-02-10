/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
Метод divisionByZero - Деление на 0
Метод numberFormatException - Ошибка преобразования строки в число

Важно: они не должны принимать никаких аргументов
*/
public class HomeWork1_1 {
    public static void main(String[] args) {
        arrayOutOfBoundsException();
        divisionByZero();
        numberFormatException();
    }

    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] arr = {1, 2, 3};
        arr[4] = 5;
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int x = 2;
        int y = 0;
        int z = x / y;
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        String str = "1 234";
        int num = Integer.parseInt(str);
    }
}