package by.bsu.study.textcleaner.presentation;

import by.bsu.study.textcleaner.service.TextHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ConsoleMenu {
    private static Logger log = LogManager.getLogger(ConsoleMenu.class.getName());

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.cleanTextMenu();
    }

    private void cleanTextMenu(){
        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder();

        System.out.println("Lab 7. Work with strings\n------");
        System.out.print("Enter your text\n>> ");
        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            if(next.equals("")) break;
            text.append(next).append("\n");
        }
        TextHandler handler = new TextHandler();

        System.out.println("Renewed text:");
        System.out.println("\"" + handler.clean(text.toString()) + "\"");
        System.out.println("\nSorted by vowels:");
        System.out.print(handler.sortByVowels(text.toString()));

        System.out.println("------");
    }
}
