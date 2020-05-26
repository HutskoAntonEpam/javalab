package by.bsu.tasks;

import java.util.Scanner;

public class Main {

    public static void cyclicShift(int[][] matrix, int n, int k, int flag) {
        int[] tmp = new int[k];
        if (flag == 1) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < k; ++j) {
                    tmp[j] = matrix[i][j];
                }
                for (int j = 0; j < (n - k); ++j) {
                    matrix[i][j] = matrix[i][j + k];
                }
                for (int j = (n - k), l = 0; j < n; ++j, ++l) {
                    matrix[i][j] = tmp[l];
                }
            }
        }
        if (flag == 2) {
            for (int i = 0; i < n; ++i) {
                for (int j = (n - k), l = 0; j < n; ++j, ++l) {
                    tmp[l] = matrix[i][j];
                }
                for (int j = (n - 1); j > (n - k); --j) {
                    matrix[i][j] = matrix[i][j - k];
                }
                for (int j = 0; j < k; ++j) {
                    matrix[i][j] = tmp[j];
                }
            }
        }
        if (flag == 3) {
            for (int j = 0; j < n; ++j) {
                for (int i = (n - k), l = 0; i < n; ++i, ++l) {
                    tmp[l] = matrix[i][j];
                }
                for (int i = (n - 1); i > (n - k); --i) {
                    matrix[i][j] = matrix[i - k][j];
                }
                for (int i = 0; i < k; ++i) {
                    matrix[i][j] = tmp[i];
                }
            }
        }
        if (flag == 4) {
            for (int j = 0; j < n; ++j) {
                for (int i = 0; i < k; ++i) {
                    tmp[i] = matrix[i][j];
                }
                for (int i = 0; i < (n - k); ++i) {
                    matrix[i][j] = matrix[i + k][j];
                }
                for (int i = (n - k), l = 0; i < n; ++i, ++l) {
                    matrix[i][j] = tmp[l];
                }
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Введите размер матрицы(n*n): ");
            n = input.nextInt();
            if (n <= 0) {
                System.out.println("Ошибка! Некорректные данные");
                continue;
            }
            break;
        } while (true);
        int[][] maxtrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                maxtrix[i][j] = (int) ((Math.random() * 2 * n) - n);
            }
        }
        System.out.println("Матрица:");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(maxtrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        int k;
        System.out.print("Введите на какое число позиций сдвинуть матрицу: ");
        k = input.nextInt();
        if (k < 0) {
            k = 0;
        }
        k %= n;
        System.out.println();
        int flag;
        System.out.print("1 - Сдвиг влево\n2 - Сдвиг вправо\n3 - Сдвиг вниз\n4 - Сдвиг вверх\nВаш выбор: ");
        flag = input.nextInt();
        System.out.println();
        cyclicShift(maxtrix, n, k, flag);
        System.out.println("Матрица после сдвига:");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(maxtrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}