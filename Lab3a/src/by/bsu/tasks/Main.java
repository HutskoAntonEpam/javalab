package by.bsu.tasks;

import java.util.Scanner;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Введите размер массива: ");
            n = input.nextInt();
            if (n <= 0) {
                System.out.print("Ошибка! Некорректные данные\n");
                continue;
            }
            break;
        } while (true);
        System.out.print("\n");
        Customer[] arr = new Customer[n];
        CustomerTools.inputArray(arr);
        int k;
        do {
            System.out.print("0 - Выход\n1 - Вывести список покупателей в алфавитном порядке\n2 - Вывести список покупателей, у которых номер кредитной карточки находится в заданном интервале\n3 - Вывести всех покупателей\n");
            System.out.print("Ваш выбор: ");
            k = input.nextInt();
            if ((k < 0) || (k > 3)) {
                System.out.print("Ошибка! Некорректные данные\n");
                continue;
            }
            System.out.print("\n");
            switch (k) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    CustomerTools.sortAlphabetOrder(arr);
                    for (Customer cust : arr) {
                        System.out.print(cust + "\n");
                    }
                    break;
                case 2:
                    long a, b;
                    System.out.print("Введите интервал для номеров карт [a, b]: ");
                    a = input.nextLong();
                    b = input.nextLong();
                    if (a > b) {
                        long tmp = a;
                        a = b;
                        b = tmp;
                    }
                    System.out.println();
                    for (Customer cust : arr) {
                        if ((cust.getCardNumber() >= a) && (cust.getCardNumber() <= b)) {
                            System.out.print(cust + "\n");
                        }
                    }
                    break;
                case 3:
                    for (Customer cust : arr) {
                        System.out.print(cust + "\n");
                    }
                    break;
            }
            System.out.print("\n");
        } while (true);
    }
}