public class Seminar1_8 {
    /*
Задание №8.
Реализуйте метод, принимающий в качестве аргументов двумерный массив.
Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
детализировать какие строки со столбцами не требуется.
 */
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        if (checkArray(arr))
            System.out.println("Array is OK");
        else System.out.println("Array is not OK");
    }

    public static boolean checkArray(int[][] arr) {
        int rows = arr.length;
        if (rows == 0) return true;
        for (int i = 0; i < rows; i++) {
            if (arr[i].length != arr[0].length) return false;
        }
        return true;
    }
}