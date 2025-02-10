// Реализовать консольное приложение, которое:
// 1. Принимает от пользователя строку вида
// text~num
// 2. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
// 3. Если введено print~num, выводит строку из позиции num в связном
// списке и удаляет её из списка.

import java.util.LinkedList;
import java.util.Scanner;

public class TestNum {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите строку вида text~num для добавления в список:");
            System.out.println("print~num для вывода строки и удаления");
            System.out.println("quit для завершения работы");
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] inputSplit = input.split("~");
            String text = inputSplit[0];
            int num = Integer.parseInt(inputSplit[1]);
            if (text.equals("print")) {
                if (num >= 0 && num < linkedList.size()) {
                    System.out.println(linkedList.remove(num));
                    System.out.println(linkedList);
                } else {
                    System.out.println("Введена неверная позиция");
                }
            } else {
                if (num >= 0 && num <= linkedList.size()) {
                    linkedList.add(num, text);
                    System.out.println(linkedList);
                } else {
                    System.out.println("Введена неверная позиция");
                }

            }

        }

    }
}
