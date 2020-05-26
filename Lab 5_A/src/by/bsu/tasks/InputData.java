package by.bsu.tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//класс для ввода данных из файла
public class InputData {
    //метод для заполнения парка аттракционов из файла
    public static void inputPark(ArrayList<Park.Attraction> attractions) {
        try(FileReader reader = new FileReader("data" + File.separator + "inputPark.txt"))
        {
            BufferedReader bufferedReader = new BufferedReader(reader);
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                attractions.add(new Park.Attraction(bufferedReader.readLine(), bufferedReader.readLine(), Double.parseDouble(bufferedReader.readLine())));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
