package by.bsu.tasks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Введите размер массива: ");
            n = input.nextInt();
            if (n <= 0) {
                System.out.print("Ошибка! Размер массива должен быть положительным\n");
                continue;
            }
            break;
        } while (true);
        int[] arr = new int[n];
        System.out.print("Введите массив: ");
        int max_number = 0, min_number = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
            if (i == 0) {
                max_number = arr[i];
                min_number = arr[i];
            } else {
                max_number = Math.max(max_number, arr[i]);
                min_number = Math.min(min_number, arr[i]);
            }
        }
        System.out.println();
        System.out.println("Минимальное число: " + min_number);
        System.out.println("Максимальное число: " + max_number);
        System.out.print("\n");
    }
}
