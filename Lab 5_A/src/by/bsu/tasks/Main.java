package by.bsu.tasks;

public class Main {

    public static void main(String[] args) {
        //создаем объект парка аттракционов
        Park park = new Park();
        //заполняем его из файла
        InputData.inputPark(park.getAttractions());
        //выводим все аттракционы из нашего парка
        System.out.println(park.toString());
    }
}
