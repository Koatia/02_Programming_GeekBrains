import java.util.*;
import java.util.stream.Collectors;

public class LaptopMain {
    public static void main(String[] args) {
        HashSet<Laptop> laptops = new HashSet<>(
                Arrays.asList(new Laptop("AMD", 16, 1000, 15, "Windows"), new Laptop("AMD", 8, 500, 14, "Windows"),
                        new Laptop("AMD", 8, 500, 14, "Linux"), new Laptop("Intel", 16, 500, 14, "Windows"),
                        new Laptop("Intel", 32, 1000, 15, "Windows"), new Laptop("Intel", 8, 500, 14, "Linux"),
                        new Laptop("AMD", 16, 500, 14, "Linux"), new Laptop("Intel", 16, 500, 14, "MacOS")));
        //        for (Laptop laptop : laptops) {
        //            System.out.println(laptop);
        //        }
        laptops.forEach(System.out::println);

        choiceLaptop(laptops);
    }

    private static void choiceLaptop(HashSet<Laptop> laptops) {
        int minRam = 0;
        int minStorage = 0;
        int minScreenSize = 0;
        String desiredCpu = "";
        String desiredOS = "";

        int choice = 1;
        Map<Integer, String> specs = new TreeMap<>();
        specs.put(1, "Минимальный объем оперативной памяти (GB)");
        specs.put(2, "Минимальный объем жесткого диска (GB)");
        specs.put(3, "Минимальный размер экрана (inches)");
        specs.put(4, "Операционная система (Windows, Linux, MacOS)");
        specs.put(5, "Компьютерная архитектура (Intel, AMD)");

        Scanner scanner = new Scanner(System.in);
        while (choice < 6 && choice > 0) {
            System.out.println();

            for (Map.Entry<Integer, String> entry : specs.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue());
            }
            System.out.print(
                    "\nВведите цифру, соответствующую необходимому критерию\n(для подбора по введенным параметрам введите любое число другое число): ");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Укажите минимальный объем оперативной памяти (GB): ");
                minRam = scanner.nextInt();
            } else if (choice == 2) {
                System.out.print("Укажите минимальный объем жесткого диска (GB): ");
                minStorage = scanner.nextInt();
            } else if (choice == 3) {
                System.out.print("Укажите минимальный размер экрана (inches): ");
                minScreenSize = scanner.nextInt();
            } else if (choice == 4) {
                System.out.print("Укажите операционную систему (Windows, Linux, MacOS): ");
                desiredOS = scanner.next().trim();
            } else if (choice == 5) {
                System.out.print("Укажите компьютерную архитектуру (Intel, AMD): ");
                desiredCpu = scanner.next().trim();
            }
        }

        filterLaptop(laptops, minRam, minStorage, minScreenSize, desiredCpu, desiredOS);
    }

    private static void filterLaptop(HashSet<Laptop> laptops, int minRam, int minStorage, int minScreenSize,
                                     String desiredCpu, String desiredOS) {
        Set<Laptop> filteredLaptops = laptops.stream().filter(laptop -> laptop.getRam() >= minRam)
                .filter(laptop -> laptop.getStorage() >= minStorage)
                .filter(laptop -> laptop.getScreenSize() >= minScreenSize)
                .filter(laptop -> desiredCpu.isEmpty() || laptop.getCpu().equalsIgnoreCase(desiredCpu))
                .filter(laptop -> desiredOS.isEmpty() || laptop.getOperationSystem().equalsIgnoreCase(desiredOS))
                .collect(Collectors.toSet());

        System.out.println();
        if (filteredLaptops.isEmpty()) {
            System.out.println("Нет подходящих ноутбуков");
        } else {
            System.out.println("Эти ноутбуки подходят под Ваши требования:");
            filteredLaptops.forEach(System.out::println);
        }
    }
}