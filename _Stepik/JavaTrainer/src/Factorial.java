import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int n = readInput();
        int result;

        result = f(n);

        System.out.println(result);
    }

    public static int f(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * f(n - 1);
    }

    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}