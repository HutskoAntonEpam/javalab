package by.bsu.tasks;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //create object of class Scanner
        Scanner in = new Scanner(System.in);
        System.out.println("Создаем цветок!");
        //sozdaem ob'ect classa Flower
        Flower flower = new Flower();
        while (true) {
            System.out.println("Чтобы добавить лепесток, введите 1:");
            System.out.println("Чтобы получить количество лепестков, введите 2:");
            System.out.println("Чтобы получить цвет бутона, введите 3:");
            System.out.println("Чтобы цветок расцвел, введите 4:");
            System.out.println("Чтобы цветок завял, введите 5:");
            System.out.println("Чтобы получить состояние цветка, введите 6:");
            System.out.println("Чтобы выйти, введите 0:");
            int a;
            //input validation
            //proverka na vvod nekorectnyh dannyh
            try {
                a = in.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Введенные данные некорректны!");
                while (in.nextLine() != null);
                continue;
            }
            switch (a) {
                case 1:
                    System.out.println("Введите форму:");
                    //vvodim razmer
                    String shape = in.next();
                    System.out.println("Введите цвет:");
                    //vvodim cvet
                    String color = in.next();
                    flower.addPetal(shape, color);
                    break;
                case 2:
                    //vyvodim rolichestvo lepestkov
                    System.out.println("Количество лепестков: " + flower.getCountPetals());
                    break;
                case 3:
                    //vyvodim cvet butona
                    System.out.println("Цвет бутона: " + flower.getColorBud());
                    break;
                case 4:
                    //vyzyvaem metod, chtoby cvetok rascvel
                    flower.Bloom();
                    System.out.println("Цветок расцвел!");
                    break;
                case 5:
                    //vyzyvaem metod, chtoby cvetok zav'al
                    flower.Wilt();
                    System.out.println("Цветок завял!");
                    break;
                case 6:
                    //polychaem sosto'anie cvetka i proveraem ego
                    if (flower.getState() == 1) {
                        System.out.println("Цветок расцвел!");
                    } else if (flower.getState() == -1) {
                        System.out.println("Цветок завял!");
                    } else {
                        System.out.println("Цветок не раскрылся!");
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;

            }
        }
    }
}
