// Внутри класса Answer1 напишите метод countNTriangle, который принимает число n и возвращает его n-ое треугольное число.
// Если число n < 1 (ненатуральное) метод должен вернуть -1.
// n = 5 -> 15

class Answer1 {

    public int countNTriangle(int n) {
        // Введите свое решение ниже
        if (n < 1) {
            return -1;
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            result = result + i;
        }
        return result;
    }
}

public class HomeWork1 {

    public static void main(String[] args) {
        int n = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            n = 5;
        } else {
            n = Integer.parseInt(args[0]);
        }

        // Вывод результата на экран
        Answer1 ans = new Answer1();
        int itresume_res = ans.countNTriangle(n);
        System.out.println(itresume_res);
    }

}
