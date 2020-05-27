package by.bsu.study.texthandler.service;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TextHandler {
    public String getTextWithCapitalLetters(String filePath) throws IOException {
        FileReader sonnetStream = new FileReader(filePath); // create stream from file
        Scanner sonnetScanner = new Scanner(sonnetStream); // wrap up stream by scanner
        StringBuilder contentBuilder = new StringBuilder(); // sonnet content builder

        while (sonnetScanner.hasNextLine()) { // while not all lines are read
            String sonnetLine = sonnetScanner.nextLine(); // read file line
            String[] words = sonnetLine.split("\\s"); // split on words by space symbols
            StringBuilder lineBuilder = new StringBuilder(); // to build lines from words
            for (String word: words) {
                // transform first symbol to upper case
                word = word.substring(0,1).toUpperCase() + word.substring(1);
                lineBuilder.append(word).append(" "); // write words back in line
            }
            contentBuilder.append(lineBuilder.toString()).append("\n"); // write lines
        }

        return contentBuilder.toString();
    }

    public String getTextWithRemovedWords(String filePath) throws IOException {
        Scanner textScanner = new Scanner(new FileReader(filePath)); // wrap up stream by scanner
        StringBuilder textBuilder = new StringBuilder(); // to build lines from words

        while (textScanner.hasNextLine()) { // while not all lines are read
            // split on words by space symbols
            String[] words = textScanner.nextLine().split("\\s");

            long wordsToRemoveNum = Arrays.stream(words).filter(word -> {
                return word.length() >= 3 && word.length() <= 5;
            }).count();
            if (wordsToRemoveNum % 2 != 0) {
                wordsToRemoveNum--;
            }

            for( int i = 0, j = 0; i < words.length; i++ ) {
                if ( j != wordsToRemoveNum && words[i].length() >= 3 && words[i].length() <= 5) {
                    j++;
                    continue;
                }
                textBuilder.append(words[i]).append(" ");
            }

            textBuilder.append("\n"); // write words back in line
        }

        return textBuilder.toString();
    }

    public void writeTextFile(String path, String content) throws IOException {
        FileOutputStream fileOutStream = new FileOutputStream(path);
        byte[] contentBytes = content.getBytes();
        fileOutStream.write(contentBytes, 0, contentBytes.length);
    }

    public String getConfigValue(String configPath, String option) throws IOException {
        FileReader sonnetStream = new FileReader(configPath); // create stream from file
        Scanner sonnetScanner = new Scanner(sonnetStream); // wrap up stream by scanner

        String optionContent = ""; // to return empty value if there is no such option
        while(sonnetScanner.hasNextLine()){
            String line = sonnetScanner.nextLine(); // get line of ini file
            if (line.startsWith(option)) { // if line is the option we are looking for
                String[] optionSplit = line.split("="); // split this line on option and value
                if (optionSplit.length == 2) { // if there are value and only one "="
                    optionContent = optionSplit[1]; // gets value after "="
                    break; // stop searching
                }
            }
        }

        return optionContent.trim(); // return value without spaces
    }
}
