package by.study.lab.computer.hardware;

import java.util.Objects;

public class RAM {
    private String name;
    private String type;
    private int capacityMB;
    private int frequency;

    public RAM() {
        name = "Temp RAM";
        type = "DDR4";
        capacityMB = 8192;
        frequency = 3000;
    }
    public RAM(String name, String type, int capacityMB, int frequency) {
        this.name = name;
        this.type = type;
        setCapacityMB(capacityMB);
        setSpeed(frequency);
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getCapacityMB() {
        return capacityMB;
    }
    public int getFrequency() {
        return frequency;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCapacityMB(int capacityMB) {
        if (capacityMB < 1){
            throw new IllegalArgumentException();
        }
        this.capacityMB = capacityMB;
    }
    public void setSpeed(int frequency) {
        if (frequency < 1){
            throw new IllegalArgumentException();
        }
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacityMB=" + capacityMB +
                ", frequency=" + frequency +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RAM ram = (RAM) object;
        return capacityMB == ram.capacityMB &&
                frequency == ram.frequency &&
                name.equals(ram.name) &&
                type.equals(ram.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, type, capacityMB, frequency);
    }
}
