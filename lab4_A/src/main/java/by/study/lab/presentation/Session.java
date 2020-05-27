package by.study.lab.presentation;

import by.study.lab.computer.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.study.lab.computer.hardware.CPU;
import by.study.lab.computer.hardware.Drive;
import by.study.lab.computer.hardware.RAM;
import by.study.lab.computer.hardware.Storage;

public class Session {
    public static Logger log = LogManager.getLogger(Session.class.getName());

    public static void main(String[] args) {
        CPU cpu = new CPU("i7-8700", 6, 3.2, 95);
        Storage storage = new Storage("A1000", "SSD", 256, 1500);
        RAM ram = new RAM("Ripjaws", "DDR4", 16384, 3200);
        Drive drive = new Drive("Old Drive", "DVD", "SATA3");
        Computer pc = new Computer(cpu, storage, drive, ram);

        showLab(pc, new Computer(), new Computer());
    }

    public static void showLab(Computer pc1, Computer pc2, Computer pc3){
        System.out.println(".toString() show:");
        System.out.println("1 " + pc1.toString());
        System.out.println("2 " + pc2.toString());
        System.out.println("3 " + pc3.toString());

        System.out.println("\n.equals(...) show:");
        System.out.println("PC 1 equals to PC 2: " + pc1.equals(pc2));
        System.out.println("PC 2 equals to PC 3: " + pc2.equals(pc3) + "\n");

        try {
            System.out.println("PC 1 have " + ((pc1.virusCheck()) ? "NO viruses.\n" : "some viruses.\n"));
        } catch (Exception ex){
            System.out.println("Virus check can't be applied because of some error.\n");
            log.error(ex.getMessage());
        }

        try {
            pc1.startup();
            System.out.println("Computer enabled...");
            pc1.startup();
            System.out.println("Computer enabled...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            log.error(e.getMessage());
        }

        try {
            System.out.println("\nPC 1 have " + ((pc1.virusCheck()) ? "NO viruses." : "some viruses."));
        } catch (Exception e){
            System.out.println("Virus check can't be applied because of some error.");
            log.error(e.getMessage());
        }

        System.out.println("\nPC 1 capacity: " + pc1.storage.getCapacityGB() + "GB.");
    }
}
