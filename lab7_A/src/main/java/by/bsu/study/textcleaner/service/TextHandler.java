package by.bsu.study.textcleaner.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class TextHandler {
    private static Logger log = LogManager.getLogger(TextHandler.class.getName());

    /* Из текста удалить все символы, кроме пробелов, не являющиеся буквами. Между
    последовательностями подряд идущих букв оставить хотя бы один пробел.*/
    public String clean(String str){
        return str.trim() //убираем пробельные символы из начала и конца строки
                .replaceAll("[^a-zA-Z\\sа-яА-Я]","") //убираем все не входящее в этот диапазон
                .replaceAll("[\\s]{2,}", " "); //заменяем любые два пробела и больше на один
    }

    /* Рассортировать слова текста по возрастанию доли гласных букв
    (отношение количества гласных к общему количеству букв в слове).*/
    public String sortByVowels(String str){
        StringBuilder sorted = new StringBuilder();
        AtomicInteger i = new AtomicInteger(1);
        String[] words = clean(str).split("\\s");

        Arrays.stream(words).distinct().sorted((String str1, String str2) -> {
            long numOfVowels1 = Arrays.stream(str1.split(""))
                    .filter(ch -> ch.matches("[ауоыиэяюёАУОЫИЭЯЮЁaeiouyAEIOUY]"))
                    .count();
            long numOfVowels2 = Arrays.stream(str2.split(""))
                    .filter(ch -> ch.matches("[ауоыиэяюёАУОЫИЭЯЮЁaeiouyAEIOUY]"))
                    .count();
            return Double.compare((double)numOfVowels2/str2.length(), (double)numOfVowels1/str1.length());
        }).forEach(word -> sorted.append((i.getAndAdd(1))).append(". ").append(word).append("\n"));

        return sorted.toString();
    }
}
