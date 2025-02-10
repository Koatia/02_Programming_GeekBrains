// Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке от 1 до 1000, каждое на новой строке.
// Напишите свой код в методе printPrimeNums класса Answer2.

class Answer2 {

    public void printPrimeNums() {
        // Напишите свое решение ниже
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

public class HomeWork2 {

    public static void main(String[] args) {

        Answer2 ans = new Answer2();
        ans.printPrimeNums();
    }
}
