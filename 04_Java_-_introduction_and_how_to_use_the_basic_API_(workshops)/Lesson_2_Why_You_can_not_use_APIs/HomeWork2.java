// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
// Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на вход один параметр:
// int[] arr - числовой массив
// После каждого прохода по массиву ваш код должен делать запись в лог-файл 'log.txt'
// в формате год-месяц-день час:минуты {массив на данной итерации}.
// Для логирования использовать логгер logger класса BubbleSort.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class BubbleSort {

    // Создание логгера с нужным форматом вывода
    private static Logger logger = null;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tR %5$s %n");
        logger = Logger.getLogger(BubbleSort.class.getName());
    }

    public void sort(int[] mas) {
        setLogger();
        bubbleSort(mas);
    }

    private int[] bubbleSort(int[] mas) {
        Boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    // Обмен значений, если текущий элемент больше следующего
                    int buffer = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buffer;
                    isSorted = false; // Обмен выполнен
                }
            }
            // Вывод текущего состояния массива после каждой итерации цикла
            logger.info(Arrays.toString(mas));
        }
        return mas;
    }

    public void setLogger() {
        try {
            FileHandler fileHandler = new FileHandler("log.txt", false); // true - append to file, false - overwritext
            // file
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false); // Отключение вывода логов в терминал

            SimpleFormatter sf = new SimpleFormatter();
            fileHandler.setFormatter(sf);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class HomeWork2 {

    // Ожидаемый ответ:
    // 2024-03-07 23:05 [3, 4, 8, 2, 5, 7, 1, 6, 9, 10]
    // 2024-03-07 23:05 [3, 4, 2, 5, 7, 1, 6, 8, 9, 10]
    // 2024-03-07 23:05 [3, 2, 4, 5, 1, 6, 7, 8, 9, 10]
    // 2024-03-07 23:05 [2, 3, 4, 1, 5, 6, 7, 8, 9, 10]
    // 2024-03-07 23:05 [2, 3, 1, 4, 5, 6, 7, 8, 9, 10]
    // 2024-03-07 23:05 [2, 1, 3, 4, 5, 6, 7, 8, 9, 10]
    // 2024-03-07 23:05 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    // 2024-03-07 23:05 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 3, 4, 8, 2, 5, 7, 1, 6, 10};
        } else {
            arr = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}