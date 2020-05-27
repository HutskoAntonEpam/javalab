package by.study.bsu.phones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class PhoneMain {
    public static Logger log = LogManager.getLogger(PhoneMain.class.getName());//log4j2
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int number;
        System.out.print("Enter number of subs to generate.\n>> ");
        while (!sc.hasNextInt() || (number = sc.nextInt()) <= 0){ //check for proper input
            wrongInput(sc);
            System.out.print(">> ");
        }
        Phone[] subs = generateSubs(number);//generate random sets of letters
        sortSubs(subs);//sort in alphabet order
        menu(subs);//call of menu
    }

    public static void menu(Phone[] subs) {
        int choose = -1;
        while(choose != 4){
            System.out.print( "\"Меню\""
                    + "\n------\n"
                    + "1. Show all subs in alphabet order;\n"
                    + "2. Show subs with particular town time;\n"
                    + "3. Show subs that have distance calls;\n"
                    + "4. Exit.\n"
                    + "------\n"
                    +"Choose menu item.\n>> ");
            while (!sc.hasNextInt() || (choose = sc.nextInt()) < 1 || choose > 4){ //check for proper input
                wrongInput(sc);
                System.out.print(">> ");
            }

            switch (choose) {
                case 1:
                    showSubs(subs);
                    break;
                case 2: {
                    double limit;
                    System.out.print("Enter limit of time.\n>> ");
                    while (!sc.hasNextDouble() || (limit = sc.nextDouble()) < 0) { //check for proper input
                        wrongInput(sc);
                        System.out.print(">> ");
                    }
                    int numOfPickedSubs = 0;
                    for (Phone sub : subs) {
                        if (sub.getTownCallsTime() > limit) {
                            numOfPickedSubs++;
                        }
                    }
                    Phone[] pickedSubs = new Phone[numOfPickedSubs];
                    for (int i = 0, j = 0; i < subs.length; i++) {
                        if (subs[i].getTownCallsTime() > limit) {
                            pickedSubs[j] = subs[i];
                            j++;
                        }
                    }
                    showSubs(pickedSubs);
                    break;
                }
                case 3: {
                    int numOfPickedSubs = 0;
                    for (Phone sub : subs) {
                        if (sub.getDistanceCallsTime() > 0) {
                            numOfPickedSubs++;
                        }
                    }
                    Phone[] pickedSubs = new Phone[numOfPickedSubs];
                    for (int i = 0, j = 0; i < subs.length; i++) {
                        if (subs[i].getDistanceCallsTime() > 0) {
                            pickedSubs[j] = subs[i];
                            j++;
                        }
                    }
                    showSubs(pickedSubs);
                }
            }
        }
    }

    private static void wrongInput(Scanner sc){
        sc.nextLine();
        System.out.println("Input error.");
    }

    public static Phone[] generateSubs(int number){
        Phone[] subs = new Phone[number];
        for (int i = 0; i < subs.length; i++) {
            subs[i] = generateSub();
        }
        return subs;
    }
    public static Phone generateSub(){
        Random rand = new Random();
        String[] words = generateRandomWords(4);
        Phone sub = new Phone(rand.nextInt(1000), words[0]
                , words[1], words[2], words[3], rand.nextInt(999999999));
        sub.setDebit(BigDecimal.valueOf((double) rand.nextInt(100) + (double) rand.nextInt(100) / 100.));
        sub.setCredit(BigDecimal.valueOf((double) rand.nextInt(100) + (double) rand.nextInt(100) / 100.));
        sub.setTownCallsTime((double)rand.nextInt(100) + (double)rand.nextInt(100)/100.);

        int distance = rand.nextInt(2);
        if (distance == 1) {
            sub.setDistanceCallsTime((double)rand.nextInt(100) + (double)rand.nextInt(100) / 100.);
        }
        else{
            sub.setDistanceCallsTime(0);
        }

        return sub;
    }
    public static String[] generateRandomWords(int numberOfWords) { //generate random words consisting of random letter
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8)+3]; // words length from 3 to 10
            for(int j = 0; j < word.length; j++) {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static void sortSubs(Phone[] subs) {
        for (int i = 0; i < subs.length; i++) {
            for (int j = i + 1; j < subs.length; j++) {
                if (subs[i].getSecondName().compareTo(subs[j].getSecondName()) > 0)
                {
                    Phone temp = subs[i];
                    subs[i] = subs[j];
                    subs[j] = temp;
                }
            }
        }
    }
    public static void showSubs(Phone[] subs){
        System.out.println("\n------");
        for (int i = 0; i < subs.length; i++) {
            System.out.println(subs[i].toString());
            if (i != subs.length - 1)
                System.out.println();
        }
        System.out.print("------\nEnter any symbol to continue...");
        try {
            System.in.read();
        }
        catch (Exception e){ }
    }
}
