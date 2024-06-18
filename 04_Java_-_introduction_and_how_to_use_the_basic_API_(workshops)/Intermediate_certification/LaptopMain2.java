import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LaptopMain2 {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>(Arrays.asList(
                new Laptop("AMD", 16, 1000, 15, "Windows"),
                new Laptop("AMD", 8, 500, 14, "Windows"),
                new Laptop("AMD", 8, 500, 14, "Linux"),
                new Laptop("Intel", 16, 500, 14, "Windows"),
                new Laptop("Intel", 32, 1000, 15, "Windows"),
                new Laptop("Intel", 8, 500, 14, "Linux"),
                new Laptop("AMD", 16, 500, 14, "Linux"),
                new Laptop("Intel", 16, 500, 14, "MacOS")));

        laptops.forEach(System.out::println);

        System.out.println("\nУкажите минимальные параметры для фильтрации подходящих ноутбуков\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите минимальный объем оперативной памяти (GB) или нажмите Enter для пропуска: ");
        int minRam = getIntInput(scanner, 0);
        System.out.print("Введите минимальный объем жесткого диска (GB) или нажмите Enter для пропуска: ");
        int minStorage = getIntInput(scanner, 0);
        System.out.print("Введите минимальный размер экрана (inches) или нажмите Enter для пропуска: ");
        int minScreenSize = getIntInput(scanner, 0);
        System.out.print("Укажите операционную систему (Windows, Linux, MacOS) или нажмите Enter для пропуска: ");
        String desiredOS = getStringInput(scanner);
        System.out.print("Укажите компьютерную архитектуру (Intel, AMD) или нажмите Enter для пропуска: ");
        String desiredCpu = getStringInput(scanner);

        filterLaptops(laptops, minRam, minStorage, minScreenSize, desiredCpu, desiredOS);
    }

    private static int getIntInput(Scanner scanner, int defaultValue) {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private static String getStringInput(Scanner scanner) {
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? null : input;
    }

    private static void filterLaptops(Set<Laptop> laptops, int minRam, int minStorage, int minScreenSize, String desiredCpu, String desiredOS) {
        Set<Laptop> filteredLaptops = laptops.stream()
                .filter(laptop -> laptop.getRam() >= minRam)
                .filter(laptop -> laptop.getStorage() >= minStorage)
                .filter(laptop -> laptop.getScreenSize() >= minScreenSize)
                .filter(laptop -> desiredCpu == null || laptop.getCpu().equalsIgnoreCase(desiredCpu))
                .filter(laptop -> desiredOS == null || laptop.getOperationSystem().equalsIgnoreCase(desiredOS))
                .collect(Collectors.toSet());

        if (filteredLaptops.isEmpty()) {
            System.out.println("\nНет подходящих ноутбуков.");
        } else {
            System.out.println("\nЭти ноутбуки подходят под Ваши требования:");
            filteredLaptops.forEach(System.out::println);
        }
    }
}