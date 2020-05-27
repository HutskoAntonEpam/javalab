package by.study.lab.computer.hardware;

import java.util.Objects;

public class CPU {
    private String name;
    private int coresNum;
    private double frequency;
    private int tdp;

    public CPU() {
        name = "Temp CPU";
        coresNum = 1;
        frequency = 1;
        tdp = 1;
    }
    public CPU(String name, int coresNum, double frequency, int tdp) {
        setCoresNum(coresNum);
        setFrequency(frequency);
        setTdp(tdp);
        this.name = name;
    }

    public int getCoresNum() {
        return coresNum;
    }
    public double getFrequency() {
        return frequency;
    }
    public int getTdp() {
        return tdp;
    }
    public String getName() {
        return name;
    }

    public void setCoresNum(int coresNum) {
        if (coresNum < 1){
            throw new IllegalArgumentException();
        }
       this.coresNum = coresNum;
    }
    public void setFrequency(double frequency) {
        if (frequency < 1){
            throw new IllegalArgumentException();
        }
        this.frequency = frequency;
    }
    public void setTdp(int tdp) {
        if (tdp < 1){
            throw new IllegalArgumentException();
        }
        this.tdp = tdp ;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                ", coresNum=" + coresNum +
                ", frequency=" + frequency +
                ", tdp=" + tdp +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CPU cpu = (CPU)object;
        return coresNum == cpu.coresNum &&
                frequency == cpu.frequency &&
                tdp == cpu.tdp &&
                name.equals(cpu.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, coresNum, frequency, tdp);
    }
}
