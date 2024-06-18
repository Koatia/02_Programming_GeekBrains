import java.util.Objects;

public class Laptop {
    private String cpu;
    private int ram;
    private int storage;
    private int screenSize;
    private String operationSystem;

    public Laptop(String cpu, int ram, int storage, int screenSize, String operationSystem) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        this.operationSystem = operationSystem;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    @Override
    public String toString() {
        return "Процессор: '" + cpu +
                "',\tОперативная память: " + ram +
                "GB,\tНакопитель: " + storage +
                "GB,\tРазмер экрана: " + screenSize +
                "inch,\tОперационная система: '" + operationSystem + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram && storage == laptop.storage && screenSize == laptop.screenSize &&
                cpu.equals(laptop.cpu) && operationSystem.equals(laptop.operationSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpu, ram, storage, screenSize, operationSystem);
    }
}