import java.util.Arrays;

public class Seminar1_7 {
    /*
Задание №7.
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива и
возвращающий новый массив, каждый элемент которого равен сумме элементов двух
входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {5, 6, 3, 2};
        try {
            int[] result = sumArrays(arr1, arr2);
            System.out.println(Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int[] sumArrays(int[] arr1, int[] arr2) throws IllegalArgumentException {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Длины массивов не равны");
        }

        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }
}