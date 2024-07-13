package Intermediate.Certification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Главный класс программы, обеспечивающий фильтрацию ноутбуков по различным критериям.
 */
public class Main {
    private static List<Laptop> laptops = new ArrayList<>();

    public static void main(String[] args) {
        LaptopFactory.initializeLaptops(laptops);

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Введите цифру, соответствующую критерию фильтрации:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("5 - Завершить программу");

            if (!scanner.hasNextInt()) {
                System.out.println("Некорректный ввод. Введите числовое значение.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) {
                System.out.println("Программа завершена.");
                break;
            }
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                Map<String, String> filters = getFiltersFromUser(choice, scanner);
                filterLaptops(filters);
            } else {
                System.out.println("Некорректный ввод.");
            }
        }

        scanner.close();
    }

    /**
     * Метод для получения фильтров от пользователя в зависимости от выбранного критерия.
     *
     * @param criterion Номер выбранного критерия фильтрации (1-ОЗУ, 2-Объем ЖД, 3-ОС, 4-Цвет).
     * @param scanner   Объект Scanner для чтения ввода пользователя.
     * @return Map с ключами-критериями и значениями-минимальными значениями для фильтрации.
     */
    private static Map<String, String> getFiltersFromUser(int criterion, Scanner scanner) {
        Map<String, String> filters = new HashMap<>();

        String key;
        switch (criterion) {
            case 1:
                key = "ram";
                break;
            case 2:
                key = "storage";
                break;
            case 3:
                key = "os";
                break;
            case 4:
                key = "color";
                break;
            default:
                System.out.println("Некорректный ввод.");
                return filters;
        }

        if (key.equals("ram") || key.equals("storage")) {
            String criterionName = key.equals("ram") ? "ОЗУ" : "Объема ЖД";
            System.out.println("Введите минимальное значение для критерия в виде числа гигабайтов '" + criterionName + "':");
            filters.put(key, getValidatedIntegerInput(scanner));
        } else {
            String criterionName = key.equals("os") ? "Операционной системы" : "Цвета";
            System.out.println("Введите минимальное значение для критерия '" + criterionName + "':");
            filters.put(key, getValidatedStringInput(scanner));
        }

        return filters;
    }

    /**
     * Метод для получения и валидации целочисленного ввода от пользователя.
     *
     * @param scanner Объект Scanner для чтения ввода пользователя.
     * @return Валидированное целочисленное значение в виде строки.
     */
    private static String getValidatedIntegerInput(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {
                return input;
            } else {
                System.out.println("Некорректный ввод. Введите целое число.");
            }
        }
    }

    /**
     * Метод для получения и валидации строкового ввода от пользователя.
     *
     * @param scanner Объект Scanner для чтения ввода пользователя.
     * @return Валидированное строковое значение.
     */
    private static String getValidatedStringInput(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (input.matches("[a-zA-Zа-яА-ЯёЁ ]+")) {
                return input;
            } else {
                System.out.println("Некорректный ввод. Введите строковое значение.");
            }
        }
    }

    /**
     * Метод для фильтрации ноутбуков по заданным критериям и вывода результата.
     *
     * @param filters Критерии фильтрации.
     */
    private static void filterLaptops(Map<String, String> filters) {
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            if (matchesFilters(laptop, filters)) {
                filteredLaptops.add(laptop);
            }
        }
        if (filteredLaptops.isEmpty()) {
            System.out.println("Ноутбуки, соответствующие заданным критериям, не найдены.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Laptop laptop : filteredLaptops) {
                System.out.println(laptop);
            }
        }
    }

    /**
     * Метод для проверки соответствия ноутбука заданным критериям фильтрации.
     *
     * @param laptop  Ноутбук для проверки.
     * @param filters Карта с критериями фильтрации и минимальными значениями для каждого критерия.
     * @return true, если ноутбук соответствует всем заданным критериям, иначе false.
     */
    private static boolean matchesFilters(Laptop laptop, Map<String, String> filters) {
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toLowerCase();

            switch (key) {
                case "ram":
                    String[] ramParts = laptop.getRam().split("\\s+");
                    if (ramParts.length < 2) {
                        return false;
                    }
                    int ramAmount = Integer.parseInt(ramParts[0]);

                    int minRamValue = Integer.parseInt(value);
                    if (ramAmount < minRamValue) {
                        return false;
                    }
                    break;
                case "storage":
                    if (convertStorageToGB(laptop.getStorage()) < Integer.parseInt(value)) {
                        return false;
                    }
                    break;
                case "os":
                    String laptopOs = laptop.getOs().toUpperCase();
                    if (!laptopOs.contains(value.toUpperCase())) {
                        return false;
                    }
                    break;
                case "color":
                    String laptopColor = laptop.getColor().toLowerCase();
                    laptopColor = laptopColor.replace('ё', 'е');
                    if (!laptopColor.contains(value.replace('ё', 'е'))) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return true;
    }


    /**
     * Метод для конвертации значения объема хранения в гигабайты.
     *
     * @param storage Объем хранения в строковом формате.
     * @return Объем хранения в гигабайтах.
     */
    private static int convertStorageToGB(String storage) {
        storage = storage.toUpperCase();
        if (storage.contains("ТБ")) {
            return Integer.parseInt(storage.replaceAll("\\D+", "")) * 1024;
        } else if (storage.contains("ГБ")) {
            return Integer.parseInt(storage.replaceAll("\\D+", ""));
        } else {
            return Integer.parseInt(storage.replaceAll("\\D+", ""));
        }
    }
}