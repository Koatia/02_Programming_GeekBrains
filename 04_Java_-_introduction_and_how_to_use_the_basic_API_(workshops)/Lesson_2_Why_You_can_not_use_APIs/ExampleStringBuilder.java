public class ExampleStringBuilder {

    public static void main(String[] args) {
        Task1();
        Task2();
    }

    public static void Task1() {
        // Дано четное число N (>0) и символы c1 и c2.
        // Написать метод, который вернет строку длины N, которая
        // состоит из чередующихся символов c1 и c2, начиная с c1.

        System.out.println("\nTask1");
        int N = 50;
        char c1 = 'a';
        char c2 = 'b';

        long start = System.currentTimeMillis();

        String sb = getStringBuilder(N, c1, c2);

        System.out.println(sb);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    private static String getStringBuilder(int N, char c1, char c2) {
        StringBuilder sb = new StringBuilder(N);
        // String sb = "";

        for (int i = 0; i < N / 2; i++) {
            sb.append(c1).append(c2);
            // sb = sb + c1 + c2;
        }
        return sb.toString();
    }

    public static void Task2() {
        // Напишите метод, который сжимает строку.
        // Пример: вход aaaabbbcdd. Выход a4b3c1d2.
        // Если в строке нет повторяющихся символов,
        // то возвращаем строку без изменений.

        System.out.println("\nTask2");
        String s = "aaaabbbcdd";

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            } else if (i == s.length() - 1) {
                sb.append(s.charAt(i)).append(++count);
            } else {
                count++;
            }
        }
        System.out.println(sb.toString());
    }
}