public class Seminar1_0 {
    /*
    Задание №0.
    Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
    Если длина массива меньше некоторого заданного минимума,
    метод возвращает -1 в качестве кода ошибки, иначе - длину массива.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int minLength = 4;
        int result = checkArray(arr, minLength);

        System.out.println(result);
    }

    public static int checkArray(int[] arr, int minLength) {
        if (arr.length < minLength) {
            return -1;
        } else {
            return arr.length;
        }
    }
}