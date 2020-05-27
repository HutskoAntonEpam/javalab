package by.bsu.study.shakespeare.service;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class StackHandler {
    public Stack<String> getFileStack(String filePath) throws IOException {
        FileReader sonnetStream = new FileReader(filePath); // create stream from file
        Scanner fileScanner = new Scanner(sonnetStream); // wrap up stream by scanner
        Stack<String> fileStack = new Stack<>();

        while (fileScanner.hasNextLine()) { // while not all lines are read
            fileStack.push(fileScanner.nextLine());
        }

        return fileStack;
    }

    public String getStringFromStack(Stack<String> stack){
        StringBuilder contentBuilder = new StringBuilder();

        stack.forEach(str -> contentBuilder.append(str).append("\n"));

        return contentBuilder.toString();
    }

    public void writeTextFile(String path, String content) throws IOException {
        FileOutputStream fileOutStream = new FileOutputStream(path);
        byte[] contentBytes = content.getBytes();
        fileOutStream.write(contentBytes, 0, contentBytes.length);
    }

    public void swapStacksValues(Stack<String> stack1, Stack<String> stack2) {
        Iterator<String> iterator1 = stack1.iterator();
        Iterator<String> iterator2 = stack2.iterator();

        ArrayList<String> tempList1 = new ArrayList<>();
        ArrayList<String> tempList2 = new ArrayList<>();

        while(iterator1.hasNext()) {
            tempList1.add(iterator1.next());
        }
        while(iterator2.hasNext()) {
            tempList2.add(iterator2.next());
        }

        stack1.clear();
        stack2.clear();

        for (String str : tempList2) {
            stack1.push(str);
        }
        for (String str : tempList1) {
            stack2.push(str);
        }
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
