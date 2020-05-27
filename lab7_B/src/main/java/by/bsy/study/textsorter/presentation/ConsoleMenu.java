package by.bsy.study.textsorter.presentation;

import by.bsy.study.textsorter.handling.domain.Text;
import by.bsy.study.textsorter.handling.handler.TextHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ConsoleMenu {
    private static final Logger log = LogManager.getLogger(ConsoleMenu.class.getName());

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.SortTextMenu();
    }

    private void SortTextMenu(){
        System.out.println("Lab 7 B. Work with text and strings\n------");

        String textPath = "./target/classes/example1.txt";
        Text text;
        try {
            text = new Text(textPath);
        }
        catch (IOException ex){
            log.error(ex.toString());
            return;
        }
        TextHandler handler = new TextHandler(text);

        System.out.println("\nText words sorted by vowels:");
        System.out.println(handler.sortByVowels());

        System.out.println("------");
    }
}
