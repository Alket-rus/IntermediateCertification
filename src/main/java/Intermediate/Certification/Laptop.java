package Intermediate.Certification;

/**
 * Класс, представляющий ноутбук с основными характеристиками.
 * Включает поля для имени, объема оперативной памяти (ОЗУ), объема жесткого диска,
 * операционной системы и цвета ноутбука, а также методы для доступа и изменения этих характеристик.
 */
public class Laptop {

    /**
     * Наименование ноутбука
     */
    private String name;

    /**
     * Объем оперативной памяти (ОЗУ)
     */
    private String ram;

    /**
     * Объем жесткого диска
     */
    private String storage;

    /**
     * Операционная система
     */
    private String os;

    /**
     * Цвет ноутбука
     */
    private String color;

    /**
     * Получает объем оперативной памяти (ОЗУ).
     *
     * @return объем ОЗУ
     */
    public String getRam() {
        return ram;
    }

    /**
     * Устанавливает объем оперативной памяти (ОЗУ).
     *
     * @param ram объем ОЗУ
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Получает объем жесткого диска.
     *
     * @return объем жесткого диска
     */
    public String getStorage() {
        return storage;
    }

    /**
     * Устанавливает объем жесткого диска.
     *
     * @param storage объем жесткого диска
     */
    public void setStorage(String storage) {
        this.storage = storage;
    }

    /**
     * Получает операционную систему.
     *
     * @return операционная система
     */
    public String getOs() {
        return os;
    }

    /**
     * Устанавливает операционную систему.
     *
     * @param os операционная система
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * Получает цвет ноутбука.
     *
     * @return цвет ноутбука
     */
    public String getColor() {
        return color;
    }

    /**
     * Устанавливает цвет ноутбука.
     *
     * @param color цвет ноутбука
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Устанавливает наименование ноутбука.
     *
     * @param name наименование ноутбука
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Переопределенный метод toString() для удобного вывода объекта в строку.
     * Возвращает строку, представляющую основные характеристики ноутбука.
     *
     * @return строка с информацией о ноутбуке
     */
    @Override
    public String toString() {
        return "Имя='" + name + '\'' +
                ", ОЗУ='" + ram + '\'' +
                ", Объем ЖД='" + storage + '\'' +
                ", Операционная система='" + os + '\'' +
                ", Цвет='" + color + '\'';
    }
}