//Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort).
//Программа должна работать следующим образом:
//Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив по умолчанию.
//Сначала выводить исходный массив на экран.
//Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
//Выводить отсортированный массив на экран.

import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    // Добавляем метод heapify для восстановления свойства кучи
    private static void heapify(int[] array, int length, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, length, largest);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        buildTree(sortArray, sortLength);

        for (int i = sortLength - 1; i >= 0; i--) {
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            heapify(sortArray, i, 0);
        }
    }
}

public class HomeWork3 {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}