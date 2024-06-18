import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class HomeWork {

    public static void main(String[] args) throws Exception {
        Task1(); // Сформировать случайным образом многочлен степени k
        Task2();
    }

    public static void Task1() throws Exception {
        /*
         * Задана натуральная степень k. Сформировать случайным
         * образом список коэффициентов (значения от 0 до 100)
         * многочлена многочлен степени k.
         * Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0
         */

        int k = 2;
        String s = polynomial(k);
        System.out.println(s);
    }

    public static String polynomial(int k) {
        Random rand = new Random();

        // Generate random integers in range 0 to 100
        int a = rand.nextInt(101);
        int b = rand.nextInt(101);
        int c = rand.nextInt(101);
        String result = String.format("%dx^%d + %dx + %d = 0\n", a, k, b, c);
        return result;
    }

    public static void Task2() throws Exception {
        /*
        Даны два файла, в каждом из которых находится запись
        многочлена. Сформировать файл содержащий сумму многочленов
        */

        FileWriter fw = new FileWriter("file1.txt", false);
        fw.write(polynomial(2));
        fw.flush();
        fw.close();

        fw = new FileWriter("file2.txt", false);
        fw.write(polynomial(2));
        fw.flush();
        fw.close();

        BufferedReader br = new BufferedReader(new FileReader("file1.txt"));
        String str1 = br.readLine();
        String[] arr1 = str1.split(" ");
        br.close();

        br = new BufferedReader(new FileReader("file2.txt"));
        String str2 = br.readLine();
        String[] arr2 = str2.split(" ");
        br.close();

        int a = Integer.parseInt(arr1[0].substring(0, arr1[0].indexOf("x"))) + Integer.parseInt(arr2[0].substring(0, arr2[0].indexOf("x")));
        int b = Integer.parseInt(arr1[1] + arr1[2].substring(0, arr1[2].indexOf("x"))) + Integer.parseInt(arr2[1] + arr2[2].substring(0, arr2[2].indexOf("x")));
        int c = Integer.parseInt(arr1[3] + arr1[4]) + Integer.parseInt(arr2[3] + arr2[4]);

        String res = "(" + str1.substring(0, str1.length() - 4) + ") + (" + str2.substring(0, str2.length() - 4) + ") = ";
        res += a + "x^2 ";
        res += (b >= 0 ? "+ " : "- ") + Math.abs(b) + "x ";
        res += (c >= 0 ? "+ " : "- ") + Math.abs(c) + "\n";
        System.out.println(res);

        FileWriter fw3 = new FileWriter("file3.txt", false);
        fw3.write(res);
        fw3.flush();
        fw3.close();
    }
}

