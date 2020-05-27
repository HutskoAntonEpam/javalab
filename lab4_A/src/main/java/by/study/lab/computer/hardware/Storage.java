package by.study.lab.computer.hardware;

import java.util.Objects;

public class Storage {
    private String name;
    private String type;
    private int capacityGB;
    private double speed;

    public Storage() {
        name = "Temp HDD";
        type = "HDD";
        capacityGB = 1024;
        speed = 5400;
    }
    public Storage(String name, String type, int capacityGB, double speed) {
        this.name = name;
        this.type = type;
        setCapacityGB(capacityGB);
        setSpeed(speed);
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getCapacityGB() {
        return capacityGB;
    }
    public double getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCapacityGB(int capacityGB) {
        if (capacityGB < 1){
            throw new IllegalArgumentException();
        }
        this.capacityGB = capacityGB;
    }
    public void setSpeed(double speed) {
        if (speed < 1){
            throw new IllegalArgumentException();
        }
        this.speed = speed ;
    }

    @Override
    public String toString() {
        return "Drive{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", capacityGB=" + capacityGB +
                ", speed=" + speed +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Storage storage = (Storage) object;
        return capacityGB == storage.capacityGB &&
                storage.speed == speed &&
                name.equals(storage.name) &&
                type.equals(storage.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, type, capacityGB, speed);
    }
}
