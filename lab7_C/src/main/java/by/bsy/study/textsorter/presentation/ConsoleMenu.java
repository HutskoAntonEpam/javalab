package by.bsy.study.textsorter.presentation;

import by.bsy.study.textsorter.handling.handler.PhoneHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

public class ConsoleMenu {
    private static Logger log = LogManager.getLogger(ConsoleMenu.class.getName());

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.SortTextMenu();
    }

    private void SortTextMenu(){
        int phoneNum = 54642652;

        System.out.println("Lab 7 C. Work with text and strings\n------");
        PhoneHandler decoder = new PhoneHandler();
        String path = "./src/main/resources/dictionary.txt";

        try {
            ArrayList<String> words = decoder.getFileArray(path);
            System.out.println("Words from dictionary:");
            for(int i = 0; i < words.size(); i++){
                System.out.println((i+1) + ". " + words.get(i));
            }
            decoder.setDictionary(words);
        } catch (IOException e){
            log.error(e.getMessage());
            return;
        }

        System.out.println("\nPhone number: " + phoneNum);

        ArrayList<String> decodedNums = decoder.getDecodedNumbers(phoneNum);
        System.out.println("\nDecoded numbers: " + decodedNums.size());
        for(int i = 0; i < decodedNums.size(); i++){
                System.out.println((i+1) + ". " + decodedNums.get(i));
        }

        System.out.println("\nMaximal substrings from dictionary: ");
        ArrayList<String> substrings =  decoder.getSubstringsOfNum(phoneNum);
        for(int i = 0; i < substrings.size(); i++){
            System.out.println((i+1) + ". " + substrings.get(i));
        }
        if (substrings.size() == 0){
            System.out.println("There are no such words in dictionary");
        }

        System.out.println("------");
    }
}
