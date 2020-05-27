package motorcyclist.presentation;

import motorcyclist.service.MotorcyclistService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleMenu {
    static Logger log = LogManager.getLogger(ConsoleMenu.class.getName());

    static final Scanner sc = new Scanner(System.in);
    private final MotorcyclistService service;

    ConsoleMenu(){
        service = new MotorcyclistService();
    }

    public static void main(String[] args) {
        ConsoleMenu console = new ConsoleMenu();
        console.start();
    }

    public void start(){
        int choose = -1;
        int chooseExit = 3;
        while(choose != chooseExit) {
            System.out.print("\nMotorcyclist\n------\n" +
                    "1. Show chosen motorcyclist ammunition;\n" +
                    "2. Equip the motorcyclist;\n" +
                    "3. Exit.\n" +
                    "------\n" +
                    "Choose menu item\n>> ");
            choose = getChoose(chooseExit);
            switch (choose) {
                case 1:
                    System.out.println("\n------\n" + service.getEquipmentString() + "\n------\n");
                    pause();
                    break;
                case 2:
                    showEquipMenu();
                    break;
            }
        }
    }

    public void showEquipMenu(){
        int choose = -1;
        int chooseExit = 4;
        while(choose != chooseExit) {
            System.out.print("\nAmmunition\n------\n" +
                    "1. Sort by weight;\n" +
                    "2. Filter by price;\n" +
                    "3. Show all;\n" +
                    "4. Return.\n" +
                    "------\n" +
                    "Choose menu item\n>> ");
            choose = getChoose(chooseExit);
            if (choose != 4) {
                showAmmunition(choose);
            }
        }
    }

    void showAmmunition(int output){
        int downBorder = 0, topBorder = 0;
        if (output == 2) {
            System.out.print("Enter down border for price.\n>> ");
            downBorder = -1;
            while (downBorder < 0) { //get user choice
                downBorder = getBorder(downBorder);
            }
            System.out.print("Enter top border for price.\n>> ");
            topBorder = -1;
            while (topBorder < 0 || topBorder < downBorder) { //get user choice
                topBorder = getBorder(topBorder);
            }
        }

        ArrayList<String> amList;
        if (output == 1) {
            amList = service.getWeightSortedAmmunitionStrings();
        }
        else if (output == 2) {
            amList = service.getPriceFilteredAmmunitionStrings(downBorder, topBorder);
        }
        else {
            amList = service.getAmmunitionStrings();
        }

        int choose = -1;
        int chooseExit = amList.size() + 1;
        while(choose != chooseExit) {
            System.out.print("\nAmmunition\n------\n");
            for (int i = 0; i < amList.size(); i++) {
                System.out.println((i + 1) + ". " + amList.get(i) + ";");
            }
            System.out.print((amList.size() + 1) + ". RETURN TO MAIN MENU.\n" +
                    "------\n" +
                    "Choose menu item\n>> ");
            choose = getChoose(chooseExit);
            if (choose != chooseExit) {
                System.out.println((service.setNewAmmunition(choose - 1, output, downBorder, topBorder)) ?
                        "Ammunition updated successfully." : "Ammunition updated with error. Try again.");
                pause();
            }
        }
    }

    private int getBorder(int Border) {
        try {
            Border = sc.nextInt();
            if (Border < 0){
                wrongInput("Incorrect choice");
                System.out.print(">> ");
            }
        }
        catch (Exception ex) {
            wrongInput(ex.getMessage());
            System.out.print(">> ");
        }
        return Border;
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
    public static void pause(){
        System.out.print("Enter any symbol to continue...");
        sc.next();
        System.out.println();
    }
}
