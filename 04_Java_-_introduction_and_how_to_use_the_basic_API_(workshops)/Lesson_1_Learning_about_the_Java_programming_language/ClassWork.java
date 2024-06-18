import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class ClassWork {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1() {
        /*
         * В консоли запросить имя пользователя. В зависимости от текущего времени,
         * вывести приветствие
         */

        System.out.println("Сейчас " + LocalDateTime.now());
        int hour = LocalDateTime.now().getHour();

        getMessage(hour);
    }

    private static void getMessage(int hour) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);

        String message;

        if (hour >= 5 && hour < 12) {
            message = "Доброе утро, ";
        } else if (hour >= 12 && hour < 18) {
            message = "Добрый день, ";
        } else if (hour >= 18 && hour < 23) {
            message = "Добрый вечер, ";
        } else {
            message = "Доброй ночи,  ";
        }

        System.out.println(message + name);
        iScanner.close();
    }

    public static void task2() {
        int[] nums = {3, 2, 1, 2, 3};
        int val = 3;
        int insertPos = 0;

        ReSort(nums, val, insertPos);

        // Вывод результата
        System.out.println(Arrays.toString(nums));
    }

    private static void ReSort(int[] nums, int val, int insertPos) {
        // Переместить все элементы, не равные val, в начало массива.
        for (int num : nums) {
            if (num != val) {
                nums[insertPos++] = num;
            }
        }
        // Заполнить оставшуюся часть массива элементами, равными val.
        while (insertPos < nums.length) {
            nums[insertPos++] = val;
        }
    }

    public static void task3() {
        /*
         * Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном
         * порядке
         */
        String phrase = "Добро пожаловать на курс по Java";
        String[] words = phrase.split(" ");

        StringBuilder result = new StringBuilder(words[words.length - 1]);

        for (int i = words.length - 2; i >= 0; i--) {
            result.append(" ").append(words[i]);
        }

        System.out.println(phrase);
        System.out.println(result);
    }

    public static void task4() {
        /*
         * Задан массив, например, nums = [1,7,3,6,5,6].
         * Написать программу, которая найдет индекс i для этого массива
         * такой, что сумма элементов с индексами < i равна сумме
         * элементов с индексами > i.
         */
        int nums[] = {1, 7, 3, 6, 1, 6, 5, 6};

        System.out.println(Arrays.toString(nums));

        System.out.println(findIndex(nums));
    }

    public static int findIndex(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            // Проверяем, равна ли сумма элементов слева сумме элементов справа от текущего
            // индекса
            if (leftSum == totalSum - leftSum - arr[i]) {
                return i;
            }
            leftSum += arr[i];
        }

        return -1; // Возвращаем -1, если такого индекса нет
    }

    public static void task5() {
        int nums[] = {1, 1, 0, 1, 1, 1};
        System.out.println(Arrays.toString(nums));

        int CountOneMax = getCountOneMax(nums);
        System.out.println(CountOneMax);
    }

    private static int getCountOneMax(int[] nums) {
        int CountOne = 0;
        int CountOneMax = 0;
        for (int num : nums) {
            if (num == 1) {
                CountOne++;
            } else {
                CountOne = 0;
            }
            CountOneMax = Math.max(CountOneMax, CountOne);
        }
        return CountOneMax;
    }
}