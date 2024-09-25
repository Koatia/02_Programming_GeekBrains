import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] parseInput = input();
        if (quantityCheck(parseInput)) {
            if (qualityCheck(parseInput)) {
                System.out.println("Данные введены верно");
                save(parseInput);
            }
        }
    }

    private static String[] input() {
        System.out.println("Введите данные в произвольном порядке, разделенные пробелом:" +
                " Фамилия Имя Отчество датарождения номертелефона пол");

        //        String[] parseInput = "Иванов Иван Иванович 10.08.2001 89218883333 f".split(" ");

        Scanner scanner = new Scanner(System.in);
        String[] parseInput = scanner.nextLine().split(" ");
        scanner.close();

        return parseInput;
    }

    private static boolean quantityCheck(String[] parseInput) {
        if (parseInput.length == 6) {
            return true;
        } else if (parseInput.length < 6) {
            System.out.println("Введено данных меньше, чем требуется");
            return false;
        } else {
            System.out.println("Введено данных больше, чем требуется");
            return false;
        }
    }

    private static boolean qualityCheck(String[] parseInput) {

        try {
            LocalDate.parse(parseInput[3], java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            System.out.println("Дата рождения неверная " + parseInput[3] + " " + e.getMessage());
            return false;
        }
        try {
            Long.parseLong(parseInput[4]);
        } catch (NumberFormatException e) {
            System.out.println("Номер телефона неверный " + parseInput[4] + " " + e.getMessage());
            return false;
        }
        if (!parseInput[5].equals("f") && !parseInput[5].equals("m")) {
            System.out.println("Пол должен быть f или m: " + parseInput[5]);
            return false;
        }

        return true;
    }

    private static void save(String[] parseInput) {
        String name = parseInput[0];

        try (FileWriter writer = new FileWriter(name + ".txt", true)) {
            for (String item : parseInput) {
                writer.write("<" + item + ">");
            }
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Failed to write to file " + e.getMessage());
        }
    }
}