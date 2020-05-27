package by.bsu.study.shakespeare.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.bsu.study.shakespeare.service.StackHandler;
import java.io.IOException;
import java.util.Stack;

/*В каждом слове сонета Вильяма Шекспира заменить первую букву слова
на прописную.*/
public class ConsoleMenu {
    private static final Logger log = LogManager.getLogger(ConsoleMenu.class.getSimpleName());

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.showUI();
    }

    private void showUI(){
        System.out.println("Lab 10 A. Work with text streams\n------\n");
        StackHandler handler = new StackHandler();
        String configPath = "./src/main/resources/config.ini";

        try {
            //get paths to input and output files
            String firstStackPath = handler.getConfigValue(configPath, "firstStackPath");
            String secondStackPath = handler.getConfigValue(configPath, "secondStackPath");

            // get handler text and write it to file
            Stack<String> firstStack = handler.getFileStack(firstStackPath);
            Stack<String> secondStack = handler.getFileStack(secondStackPath);

            System.out.println("First stack:\n" + handler.getStringFromStack(firstStack));
            System.out.println("Second stack:\n" + handler.getStringFromStack(secondStack));

            handler.swapStacksValues(firstStack, secondStack);
            System.out.println("-------------\n");

            System.out.println("Swapped first stack:\n" + handler.getStringFromStack(firstStack));
            System.out.println("Swapped second stack:\n" + handler.getStringFromStack(secondStack));

        } catch (IOException e) {
            log.error(e.getMessage());
        }

        System.out.println("------");
    }
}
