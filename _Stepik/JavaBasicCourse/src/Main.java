import java.security.MessageDigest;

public class Main {
    public static void main(String[] args) {
        int a = 25;
        System.out.print((char) ('\\' + a));
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }

}