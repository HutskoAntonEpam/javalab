package by.bsu.study.texthandler.presentation;


import by.bsu.study.texthandler.service.TextHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

/*В каждом слове сонета Вильяма Шекспира заменить первую букву слова
на прописную. Из файла удалить все слова, содержащие от трех до пяти символов, но при
этом из каждой строки должно быть удалено только максимальное четное
количество таких слов.*/
public class TextMenu {
    private static final Logger log = LogManager.getLogger(TextMenu.class.getSimpleName());

    public static void main(String[] args) {
        TextMenu menu = new TextMenu();
        menu.showUI();
    }

    private void showUI(){
        System.out.println("Lab 9 A, C. Work with text streams\n------\n");
        TextHandler handler = new TextHandler();
        String configPath = "./src/main/resources/config.ini";

        try {
            // get paths to input and output files
            String sonnetPathIn = handler.getConfigValue(configPath, "sonnetPathInput");
            String sonnetPathOut = handler.getConfigValue(configPath, "sonnetPathOutput");
            String removedWordsOut = handler.getConfigValue(configPath, "removedWordsOutput");

            // create directory for new file
            File file = new File(removedWordsOut);
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            // get handled text from file and write it to the new file
            // A part
            String sonnet = handler.getTextWithCapitalLetters(sonnetPathIn);
            handler.writeTextFile(sonnetPathOut, sonnet); // write handler sonnet

            // C part
            String removedWords = handler.getTextWithRemovedWords(sonnetPathIn);
            handler.writeTextFile(removedWordsOut, removedWords);

            // output handled sonnet to console
            //A part
            System.out.println("Sonnet where all words starts with capital letter:\n");
            System.out.println(sonnet);
            System.out.println("-----\n");
            // C part
            System.out.println("Sonnet where removed words:\n");
            System.out.println(removedWords);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        System.out.println("------");
    }
}
