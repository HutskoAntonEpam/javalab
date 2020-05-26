package by.bsu.tasks;

import java.util.Scanner;

/**
 * A program that sort and display numbers in ascending (descending) order of values their lengths
 * <p>
 * Task received: 15.02.2020 8.15
 * <p>
 * Task completed: 22.02.2020 8.15
 *
 * @author Martinevski Denis
 * @version 1.0
 */
public class Main {

    /**
     * Method finding the number of digits in a number
     *
     * @param String - the String object with a number
     * @return int - number of digits in a number
     */
    public static int getCntDigits(String number) {
        if (number.charAt(0) == '-')
            return (number.length() - 1);
        else
            return number.length();
    }

    /**
     * Method sorting an array of increasing (decreasing) lengths of numbers
     *
     * @param String[],boolean - the String array with a numbers and a boolean variable for sorting order
     */
    public static void sort(String[] numbers, boolean flag) {
        boolean flg;
        for (int i = 0; i < (numbers.length - 1); ++i) {
            flg = false;
            for (int j = 0; j < (numbers.length - 1 - i); ++j) {
                if (flag == true) {
                    if (getCntDigits(numbers[j]) > getCntDigits(numbers[j + 1])) {
                        String tmp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = tmp;
                        flg = true;
                    }
                } else {
                    if (getCntDigits(numbers[j]) < getCntDigits(numbers[j + 1])) {
                        String tmp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = tmp;
                        flg = true;
                    }
                }
            }
            if (flg == false)
                break;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите размер массива: ");
            n = input.nextInt();
            if (n <= 0) {
                System.out.println("Ошибка! Некорректные данные");
                continue;
            }
            break;
        } while (true);
        String[] numbers = new String[n];
        System.out.print("Введите числа: ");
        for (int i = 0; i < n; ++i) {
            numbers[i] = input.next();
        }
        int k;
        System.out.print("1 - Сортировка по возрастанию\n2 - Сортировка по убыванию\nВаш выбор: ");
        k = input.nextInt();
        System.out.println();
        if (k == 1) {
            sort(numbers, true);
        } else {
            sort(numbers, false);
        }
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < n; ++i) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}