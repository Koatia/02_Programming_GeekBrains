import java.util.Arrays;

//Внутри класса MergeSort напишите метод mergeSort, который принимает массив целых чисел,
//реализует алгоритм сортировки слиянием. Метод должен возвращать отсортированный массив.

class MergeSort {

    public static int[] mergeSort(int[] a) {
        return split(a);
    }

    public static int[] split(int[] array) {
        if (array.length == 1) return array;
        if (array.length == 2) return mergeArrays(new int[]{array[0]}, new int[]{array[1]});

        int[] left = new int[array.length / 2];
        int[] right = new int[array.length - array.length / 2];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);

        return mergeArrays(split(left), split(right));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a = new int[a1.length + a2.length];
        int i = 0, i1 = 0, i2 = 0;

        while (i1 < a1.length && i2 < a2.length) a[i++] = a1[i1] < a2[i2] ? a1[i1++] : a2[i2++];
        while (i1 < a1.length) a[i++] = a1[i1++];
        while (i2 < a2.length) a[i++] = a2[i2++];
        return a;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class HomeWork1 {
    public static void main(String[] args) {
        int[] a;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}