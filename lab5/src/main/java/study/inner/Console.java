package study.inner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Console {
    static Logger log = LogManager.getLogger(Console.class.getName());
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Console console = new Console();
        console.start();
    }

    public void start() {
        Europe europe = new Europe();
        europe.add("Belarus", 1996, "something");
        europe.add("England", 1560, "da");
        europe.add("Latvia", 1996, "something happened");
        europe.add("Latvia", 1996, "and one more");
        europe.add("Uruguay", 2001, "Africa?");

        Europe.HistoryDates histDate = new Europe.HistoryDates();
        System.out.println("Static class use: " + histDate.toString() + "\n");
        pause();

        Europe europeAnonymous = new Europe(){
            @Override
            public String getFirstHistory(){
                if (history.size() > 0)
                    return "(Теперь анонимный)" + history.get(0).toString();
                return "(Анонимный теперь)";
            }
        };
        europeAnonymous.add("Belarus", 1996, "something");
        System.out.println("Anonymous class use: " + europeAnonymous.getFirstHistory() + "\n");
        pause();
        /*-------*/

        AtomicInteger i = new AtomicInteger();

        System.out.println("\nAll history.\n------");
        i.set(1);
        europe.getAllHistory().forEach(hist -> System.out.println((i.getAndIncrement()) + ". " + hist));
        System.out.println("------\n");
        pause();

        System.out.println("\nAll countries.\n------");
        i.set(1);
        europe.getAllCountries().forEach(country -> System.out.println((i.getAndIncrement()) + ". " + country));
        System.out.println("------\n");
        pause();

        System.out.println("\nAll years.\n------");
        i.set(1);
        europe.getAllYears().forEach(System.out::println);
        System.out.println("------\n");
        pause();

        System.out.println("\nAll histories in year 1996.\n------");
        i.set(1);
        europe.getHistoryByYear(1996).forEach(hist -> System.out.println((i.getAndIncrement()) + ". " + hist));
        System.out.println("------\n");
        pause();
    }

    public static void pause(){
        System.out.print("Enter any symbol to continue...");
        sc.next();
        System.out.println();
    }
}
