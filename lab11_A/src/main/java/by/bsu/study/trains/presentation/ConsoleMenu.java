package by.bsu.study.trains.presentation;


import by.bsu.study.trains.domain.Train;
import by.bsu.study.trains.service.TunnelTransfer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ConsoleMenu {
    private static final Logger log = LogManager.getLogger(ConsoleMenu.class.getSimpleName());
    public static final Scanner sc = new Scanner(System.in);
    private TunnelTransfer transfer;

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.transfer = new TunnelTransfer();
        // define trains that will be used in tunnels
        Train train1 = new Train("T-1", null, 5);
        Train train2 = new Train("T-2", null, 7);
        Train train3 = new Train("P-1", null, 5);
        // add two trains to first tunnel and one to second
        menu.transfer.addTrainToFirstTunnel(train1);
        menu.transfer.addTrainToFirstTunnel(train3);
        menu.transfer.addTrainToSecondTunnel(train2);

        menu.start();
    }

    public void start(){
        int choose = -1;
        int chooseExit = 2;
        boolean started = false;
        // text of menu, when managing is off
        String menuTextOff = "------\n" +
                "1. Start moving;\n" +
                "2. Exit.\n" +
                "------\n" +
                "Choose menu item\n>> ";
        // text of menu, when managing is on
        String menuTextOn = "------\n" +
                "1. Show all info;\n" +
                "2. Exit.\n" +
                "------\n" +
                "Choose menu item\n>> ";
        // start managing is off from start
        String menuText = menuTextOff;

        System.out.println("Tunnels managing");
        while(choose != chooseExit) {
            System.out.print(menuText);
            choose = getChoose(chooseExit); // get chosen number
            if (choose == 1) {
                if (started) {
                    // get info about trains
                    System.out.println(transfer.getInfo());
                } else {
                    // switch menu to on version
                    menuText = menuTextOn;
                    // start transferring trains
                    transfer.start();
                    started = true;
                    System.out.println("Movement started.");
                }
                pause();
            }
        }

        // turn off all cycles
        transfer.turnOff();
    }

    private int getChoose(int chooseExit) {
        int choose = -1;
        while (choose < 1 || choose > chooseExit) { //get user choice
            try {
                choose = sc.nextInt();
                if (choose < 1 || choose > chooseExit){
                    wrongInput("Incorrect choice");
                    System.out.print(">> ");
                }
            }
            catch (Exception ex) {
                wrongInput(ex.getMessage());
                System.out.print(">> ");
            }
        }
        return choose;
    }

    public static void wrongInput(String message){
        sc.nextLine();
        System.out.println(message);
        log.error(message);
    }

    // wait for enter any symbol
    public static void pause(){
        System.out.print("Enter any symbol to continue...");
        sc.next();
        System.out.println();
    }
}
