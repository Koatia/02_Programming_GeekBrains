// В методе calculate класса Calculator реализовать калькулятор, который будет выполнять математические операции (+, -, *, /)
// над двумя целыми числами и возвращать результат вещественного типа.
// В классе Printer необходимо реализовать проверку переданного оператора, при некорректном операторе
// программа должна вывести сообщение об ошибке "Некорректный оператор: 'оператор'".

class Calculator {

    public double calculate(char op, int a, int b) {
        switch (op) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            case '/' -> {
                if (b == 0) {
                    throw new ArithmeticException("На ноль делить нельзя!");
                }
                return (double) a / b;
            }
            default -> throw new IllegalArgumentException("Некорректный оператор: " + op);
        }
    }
}

public class HomeWork3 {

    public static void main(String[] args) {
        int a = 3; // Значения по умолчанию
        char op = '*';
        int b = 10;

        if (args.length > 0) {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        Calculator calculator = new Calculator();
        try {
            double result = calculator.calculate(op, a, b);
            System.out.println(result);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
