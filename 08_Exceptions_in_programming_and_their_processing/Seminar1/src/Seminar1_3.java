public class Seminar1_3 {
    /*
Задание №3.
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения: метод может работать только с
квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
только значение 0 или 1.
Если нарушается одно из условий, метод должен вернуть код ошибки.
Программа должна корректно обработать код ошибки и вывести соответствующее
сообщение пользователю.
Сравнить такой вариант обработки исключений с предыдущим.
Какое преимущество у исключений перед
кодами ошибок вы можете назвать
в данном случае?
 */
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {0, 0, 0}, {1, 1, 1}};

        int result = sumElement(matrix);
        if (result == -1)
            System.out.println("Массив не квадратный");
        else if (result == -2)
            System.out.println("В массиве есть не 0 и не 1");
        else
            System.out.printf("Сумма элементов массива = %d", result);
    }

    public static int sumElement(int[][] matrix) {
        int n = matrix.length;
        for (int row[] : matrix) {
            if (row.length != n)
                return -1;
//                throw new RuntimeException("Массив не квадратный");
        }
        for (int row[] : matrix) {
            for (int element = 0; element < row.length; element++) {
                if (row[element] != 0 && row[element] != 1)
                    return -2;
//                    throw new RuntimeException("В массиве есть не 0 и не 1");
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