
import java.io.*;
import java.util.Scanner;

public class ClassWork {

    public static void main(String[] args) throws Exception {
        System.out.println("Неявная типизация");
        {
            var a = 123;
            System.out.println(a); // 123
            var d = 123.456;
            System.out.println(d); // 123.456
            System.out.println(getType(a)); // Integer
            System.out.println(getType(d)); // Double
            d = 1022;
            System.out.println(d); // 1022
            // d = "mistake";
            // error: incompatible types:
            // String cannot be converted to double
        }

        System.out.println("\n" + "Классы-обертки");
        {
            System.out.println(Integer.MAX_VALUE); // 2147483647
            System.out.println(Integer.MIN_VALUE); // -2147483648
            String s = "mistake";
            System.out.println(s);
            System.out.println(s.charAt(1)); // i

            System.out.println("\n" + "Операции Java");
            // Присваивание: =
            // Арифметические: *, /, +, -, %, ++, --
            // Операции сравнения: <, >, ==, !=, >=, <=
            // Логические операции: ||, &&, ^, !
            // Побитовые операции <<, >>, &, |, ^
            s = "doom1";
            boolean b = s.length() >= 5 && s.charAt(4) == '1';
            System.out.println(b);
        }

        System.out.println("\n" + "Одномерные Массивы");
        {
            int[] arr = new int[10];
            System.out.println(arr.length); // 10
            arr = new int[] { 1, 2, 3, 4, 5 };
            System.out.println(arr.length); // 5
        }

        System.out.println("\n" + "Многомерные Массивы");
        {
            int[] arr[] = new int[3][5];
            for (int[] line : arr) {
                for (int item : line) {
                    System.out.printf("%d ", item);
                }
                System.out.println();
            }
        }

        System.out.println("\n" + "Преобразования");
        {
            int i = 123;
            double d = i;
            System.out.println(i); // 123
            System.out.println(d); // 123.0
            d = 3.1415;
            i = (int) d;
            System.out.println(d); // 3.1415
            System.out.println(i); // 3
            d = 3.9415;
            i = (int) d;
            System.out.println(d); // 3.9415
            System.out.println(i); // 3
            byte b = Byte.parseByte("123");
            System.out.println(b); // 123
            // b = Byte.parseByte("1234");
            // System.out.println(b); // NumberFormatException: Value out of range
        }

        System.out.println("\n" + "Получение данных из терминала");
        Scanner iScanner = new Scanner(System.in, "Cp866");

        System.out.println("Строки");
        {
            // Scanner iScanner = new Scanner(System.in);
            System.out.print("name: ");
            String name = iScanner.nextLine();
            System.out.printf("Привет, %s!", name);
            // iScanner.close();
        }
        System.out.println("\n" + "Некоторые примитивы");
        {
            // Scanner iScanner = new Scanner(System.in);
            System.out.print("int x: ");
            int x = iScanner.nextInt();
            System.out.print("double y: ");
            double y = iScanner.nextDouble();
            System.out.printf("%d + %f = %f", x, y, x + y);
            // iScanner.close();
        }
        System.out.println("\n" + "Проверка на соответствие получаемого типа");
        {
            // Scanner iScanner = new Scanner(System.in);
            System.out.print("int a: ");
            boolean flag;
            do {
                flag = iScanner.hasNextInt();
                if (!flag) {
                    System.out.println("Это не целое число. Пожалуйста, введите целое число.");
                    iScanner.next(); // Важно! Это "съедает" неверный ввод перед следующей итерацией
                }
            } while (!flag);

            int i = iScanner.nextInt();
            System.out.println("Вы ввели число: " + i);

            iScanner.close();
        }
        iScanner.close();

        System.out.println("\n" + "Форматированный вывод");

        {
            int a = 1, b = 2;
            int c = a + b;
            String res = String.format("%d + %d = %d \n", a, b, c);
            System.out.printf("%d + %d = %d \n", a, b, c);
            System.out.println(res);
            // Виды спецификаторов
            // %d: целочисленных значений
            // %x: для вывода шестнадцатеричных чисел
            // %f: для вывода чисел с плавающей точкой
            // %e: для вывода чисел в экспоненциальной форме, например 3.1415e+01
            // %c: для вывода одиночного символа
            // %s: для вывода строковых значений
            float pi = 3.1415f;
            System.out.printf("%f\n", pi); // 3,141500
            System.out.printf("%.2f\n", pi); // 3,14
            System.out.printf("%.3f\n", pi); // 3,141
            System.out.printf("%e\n", pi); // 3,141500e+00
            System.out.printf("%.2e\n", pi); // 3,14e+00
            System.out.printf("%.3e\n", pi); // 3,141e+00
        }

        System.out.println("\n" + "Управляющие конструкции:");
        System.out.println("тернарный оператор");
        {
            int a = 1;
            int b = 2;
            int min = a < b ? a : b;
            System.out.println(min);
        }

        System.out.println("\n" + "Цикл do while");
        {
            int value = 321;
            int count = 0;
            do {
                value /= 10;
                count++;
            } while (value != 0);
            System.out.println(count);
        }

        System.out.println("\n" + "for :\nРаботает только для коллекций");
        {
            int arr[] = new int[10];
            for (int item : arr) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }

        System.out.println("\n" + "Работа с файлами\nСоздание и запись\\дозапись");
        {
            try (FileWriter fw = new FileWriter("file.txt", false)) {
                fw.write("line 1");
                fw.append('\n');
                fw.append('2');
                fw.append('\n');
                fw.write("line 3");
                fw.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("\n" + "Работа с файлами\nЧтение, Вариант посимвольно");
        {
            FileReader fr = new FileReader("file.txt");
            int c;
            while ((c = fr.read()) != -1) {
                char ch = (char) c;
                if (ch == '\n') {
                    System.out.print(ch);
                } else {
                    System.out.print(ch);
                }
            }
            fr.close();
        }

        System.out.println("\n" + "Работа с файлами\nВариант построчно");
        {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String str;
            while ((str = br.readLine()) != null) {
                System.out.printf("== %s ==\n", str);
            }
            br.close();
        }

    }

    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}
