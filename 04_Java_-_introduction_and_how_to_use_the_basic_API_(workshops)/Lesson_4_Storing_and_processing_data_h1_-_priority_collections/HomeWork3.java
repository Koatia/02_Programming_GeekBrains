//В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
//Отмена последней операции должна быть реализована следующим образом: если передан оператор '<' калькулятор должен вывести результат предпоследней операции.

import java.util.ArrayDeque;
import java.util.Deque;

class Calculator {
    private Deque<Integer> history = new ArrayDeque<>();

    public int calculate(char op, int a, int b) {
        // Напишите свое решение ниже
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("Ошибка: деление на ноль");
                }
                result = a / b;
                break;
            case '<':
                if (history.size() < 2) {
                    throw new IllegalStateException(
                            "Недостаточно операций в истории для возврата предпоследнего результата");
                }
                history.pop(); // Удаляем последний результат
                result = history.peekFirst(); // Получаем предпоследний результат

                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        if (op != '<') {
            history.push(result);
        }
        return result;
    }

}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class HomeWork3 {
    public static void main(String[] args) {
        int a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '*';
            b = 2;
            c = 7;
            op2 = '-';
            d = 4;
            undo = '<';
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
            c = Integer.parseInt(args[3]);
            op2 = args[4].charAt(0);
            d = Integer.parseInt(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(String.format("%.1f", (float) result));
        int result2 = calculator.calculate(op2, c, d);
        System.out.println(String.format("%.1f", (float) result2));
        int prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(String.format("%.1f", (float) prevResult));
    }
}