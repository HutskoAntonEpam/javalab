package by.bsy.study.textsorter.handling.handler;

import by.bsy.study.textsorter.handling.domain.Sentence;
import by.bsy.study.textsorter.handling.domain.SymbolType;
import by.bsy.study.textsorter.handling.domain.Text;
import by.bsy.study.textsorter.handling.domain.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TextHandler {
    private static final Logger log = LogManager.getLogger(TextHandler.class.getName());

    private Text text;

    public TextHandler(Text text){
        this.text = text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public String clean(){
        return text.toString().trim() //убираем пробельные символы из начала и конца строки
                .replaceAll("[^a-zA-Z\\sа-яА-Я]","") //убираем все не входящее в этот диапазон
                .replaceAll("[\\s]{2,}", " "); //заменяем любые два пробела и больше на один
    }

    /*7. Рассортировать слова текста по возрастанию доли гласных букв
    (отношение количества гласных к общему количеству букв в слове).*/
    public String sortByVowels() {
        ArrayList<Word> words = new ArrayList<>();
        // collect all words
        for (Sentence sentence: text.getSentences()) {
            words.addAll(sentence.getSentence());
        }

        StringBuilder sorted = new StringBuilder();
        AtomicInteger i = new AtomicInteger(1);
        words.sort((Word word1, Word word2) -> {
            long vowels1 = word1.getSymbols()
                    .stream()
                    .filter(symbol -> symbol.getType() == SymbolType.VOWEL)
                    .count();
            long vowels2 = word2.getSymbols()
                    .stream()
                    .filter(symbol -> symbol.getType() == SymbolType.VOWEL)
                    .count();
            return Double.compare((double)vowels2/word2.getSize(), (double)vowels1/word1.getSize());
        });
        words.forEach(word ->
                sorted.append((i.getAndAdd(1))).append(". ").append(word.toString()).append("\n")
        );

        return sorted.toString();
    }
}
