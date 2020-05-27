package by.study.lab.computer;

import by.study.lab.computer.hardware.CPU;
import by.study.lab.computer.hardware.Storage;
import by.study.lab.computer.hardware.Drive;
import by.study.lab.computer.hardware.RAM;

import java.util.Objects;
import java.util.Random;

public class Computer {
    public CPU cpu;
    public Storage storage;
    public Drive drive;
    public RAM ram;
    private boolean enabled;

    public Computer(){
        cpu = new CPU();
        storage = new Storage();
        drive = new Drive();
        ram = new RAM();
        enabled = false;
    }
    public Computer(CPU cpu, Storage storage, Drive drive, RAM ram){
        enabled = false;
        this.cpu = new CPU(cpu.getName(), cpu.getCoresNum(), cpu.getFrequency(), cpu.getTdp());
        this.storage = new Storage(storage.getName(), storage.getType(), storage.getCapacityGB(), storage.getSpeed());
        this.drive = new Drive(drive.getName(), drive.getType(), drive.getConnection());
        this.ram = new RAM(ram.getName(), ram.getType(), ram.getCapacityMB(), ram.getFrequency());
    }

    public void startup() throws Exception {
        if (enabled) {
            throw new Exception("Computer is already enabled.");
        }
        else enabled = true;
    }
    public void shutdown() throws Exception {
        if(!enabled) {
            throw new Exception("Computer is already off.");
        }
        else enabled = false;
    }
    public boolean virusCheck() throws Exception{
        if (!enabled) {
            throw new Exception("Computer should be enable to check it for viruses.");
        }
        else {
            Random rand = new Random();
            return rand.nextInt() % 2 == 0;
        }
    }

    @Override
    public String toString() {
        return "Computer{\n" +
                cpu.toString() + ",\n" +
                storage.toString() + ",\n" +
                drive.toString() + ",\n" +
                ram.toString() + ",\n" +
                "enabled: " + ((enabled)?"yes":"no") + ";\n" +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return enabled == computer.enabled &&
                cpu.equals(computer.cpu) &&
                storage.equals(computer.storage) &&
                drive.equals(computer.drive) &&
                ram.equals(computer.ram);
    }
    @Override
    public int hashCode() {
        return Objects.hash(cpu, storage, drive, ram, enabled);
    }
}
