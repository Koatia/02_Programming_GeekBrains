public class Seminar1_2 {
    /*
Задание №2.
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения: метод может работать только с
квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об
ошибке.
 */
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {0, 0, 0}, {1, 1, 1}};

        int result = sumElement(matrix);
        System.out.println(result);
    }

    public static int sumElement(int[][] matrix) {
        int n = matrix.length;
        for (int row[] : matrix) {
            if (row.length != n)
                throw new RuntimeException("Массив не квадратный");
        }
        for (int row[] : matrix) {
            for (int element = 0; element < row.length; element++) {
                if (row[element] != 0 && row[element] != 1)
                    throw new RuntimeException("В массиве есть не 0 и не 1");
            }
        }
        int sum = 0;
        for (int row[] : matrix) {
            for (int element = 0; element < row.length; element++) {
                sum += row[element];
            }
        }
        return sum;
    }
}