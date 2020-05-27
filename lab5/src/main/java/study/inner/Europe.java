package study.inner;
/*Создать класс Европа с внутренним классом,
с помощью объектов которого можно хранить
информацию об истории изменения территориального
деления на государства*/

import java.util.ArrayList;
import java.util.Comparator;

public class Europe {
    //внутренний класс
    public class HistoryChange{
        String country;
        int year;
        String description;

        public HistoryChange(){
            country = "";
            year = 0;
            description = "";
        }
        public HistoryChange(String country, int year, String description){
            this.country = country;
            this.year = year;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Year - " + year + ", country - " + country + ".\n" +
                    "Description: " + description + ".";
        }
    }
    //вложенный статический класс
    public static class HistoryDates{
        private int year;
        private String eventDescription;

        HistoryDates(){
            year = 1521;
            eventDescription = "Something happened";
        }

        @Override
        public String toString() {
            return "In year " + year + ": " + eventDescription + ".";
        }
    }

    public ArrayList<HistoryChange> history;

    //Метод для показа анонимного класа
    public String getFirstHistory(){
        if (history.size() > 0)
            return "(Не анонимный)" + history.get(0).toString();
        return "(не анонимный)";
    }

    Europe(){
        history = new ArrayList<HistoryChange>();
    }

    public void add(String country, int year, String description){
        history.add(new HistoryChange(country, year, description));
    }

    public ArrayList<String> getAllHistory(){
        ArrayList<String> allHistory = new ArrayList<>();
        for (HistoryChange hist : history) {
            allHistory.add(hist.toString());
        }
        return allHistory;
    }
    public ArrayList<String> getHistoryByYear(int year){
        ArrayList<String> historyByYear = new ArrayList<String>();
        history.stream()
                .filter(hist -> hist.year == year)
                .forEach(hist -> historyByYear.add(hist.toString()));
        return historyByYear;
    }
    public ArrayList<Integer> getAllYears(){
        ArrayList<Integer> years = new ArrayList<Integer>();
        history.stream()
                .map(hist -> hist.year)
                .distinct()
                .sorted(Comparator.comparingInt(year->year))
                .forEach(years::add);
        return years;
    }
    public ArrayList<String> getAllCountries(){
        ArrayList<String> countries = new ArrayList<String>();
        history.stream()
                .map(hist -> hist.country)
                .distinct()
                .forEach(countries::add);
        return countries;
    }
}
