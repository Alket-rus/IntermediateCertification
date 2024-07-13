package Intermediate.Certification;

import java.util.List;

/**
 * Класс для создания и инициализации объектов ноутбуков.
 */
public class LaptopFactory {

    /**
     * Метод для инициализации списка ноутбуков. Добавляет несколько ноутбуков в список.
     *
     * @param laptops список ноутбуков для инициализации
     */
    public static void initializeLaptops(List<Laptop> laptops) {
        laptops.add(createApple());
        laptops.add(createDell());
        laptops.add(createLenovo());
        laptops.add(createAsus());
        laptops.add(createHP());
    }

    /**
     * Метод для создания и возвращения объекта ноутбука HP Spectre x360 14.
     *
     * @return Объект ноутбука HP Spectre x360 14.
     */
    public static Laptop createHP() {
        Laptop laptop = new Laptop();
        laptop.setName("HP Spectre x360 14");
        laptop.setRam("16 ГБ");
        laptop.setStorage("1 ТБ SSD");
        laptop.setOs("Windows 10");
        laptop.setColor("Ночной синий");
        return laptop;
    }

    /**
     * Метод для создания и возвращения объекта ноутбука ASUS ROG Zephyrus G14.
     *
     * @return Объект ноутбука ASUS ROG Zephyrus G14.
     */
    public static Laptop createAsus() {
        Laptop laptop = new Laptop();
        laptop.setName("ASUS ROG Zephyrus G14");
        laptop.setRam("32 ГБ");
        laptop.setStorage("1 ТБ SSD");
        laptop.setOs("Windows 10");
        laptop.setColor("Лунно-белый");
        return laptop;
    }

    /**
     * Метод для создания и возвращения объекта ноутбука Lenovo ThinkPad X1 Carbon (Gen 9).
     *
     * @return Объект ноутбука Lenovo ThinkPad X1 Carbon (Gen 9).
     */
    public static Laptop createLenovo() {
        Laptop laptop = new Laptop();
        laptop.setName("Lenovo ThinkPad X1 Carbon (Gen 9)");
        laptop.setRam("16 ГБ");
        laptop.setStorage("512 ГБ SSD");
        laptop.setOs("Windows 10 Pro");
        laptop.setColor("Чёрный");
        return laptop;
    }

    /**
     * Метод для создания и возвращения объекта ноутбука Dell XPS 13 (9310).
     *
     * @return Объект ноутбука Dell XPS 13 (9310).
     */
    public static Laptop createDell() {
        Laptop laptop = new Laptop();
        laptop.setName("Dell XPS 13 (9310)");
        laptop.setRam("16 ГБ");
        laptop.setStorage("512 ГБ SSD");
        laptop.setOs("Windows 10");
        laptop.setColor("Платиновый серебристый");
        return laptop;
    }

    /**
     * Метод для создания и возвращения объекта ноутбука Apple MacBook Air M1 (2020).
     *
     * @return Объект ноутбука Apple MacBook Air M1 (2020).
     */
    public static Laptop createApple() {
        Laptop laptop = new Laptop();
        laptop.setName("Apple MacBook Air M1 (2020)");
        laptop.setRam("8 ГБ");
        laptop.setStorage("256 ГБ SSD");
        laptop.setOs("macOS");
        laptop.setColor("Серебристый");
        return laptop;
    }
}