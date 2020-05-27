import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * The second lab class
 * @author Timofey Ivanov
 * @version 1.0*/
public class DIffDigits {
    /**log4j logger*/
    public static Logger log = LogManager.getLogger();
    /**Start function
     * @param args - console arguments(no use)*/
    
    public static void main(String[] args) {
        log.info("Program started");

        System.out.println("-----------\nVariant A:");
        labFirstPart();
        System.out.println("\n-----------\nVariant B:");
        labSecondPart();
        System.out.println("-----------\n");

        System.out.println("Author: Timofey Ivanov;");
        SimpleDateFormat date = new SimpleDateFormat("dd MMMM yyyy 'at' HH:mm:ss", Locale.ENGLISH);
        System.out.println("Task receiving time is: " + date.format(new Date(1581750630000L)));
        System.out.println("Task showing time(current) is: " + date.format(new Date()));

        log.info("Program end");
    }

    /*Найти число, состоящее только из различных цифр. Если таких
    чисел несколько, найти первое из них.*/
    /**Part A of the second lab. Find number consisting of different digits*/
    private static void labFirstPart(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers do you want to enter(use\n"
                + "'-' if you want to generate numbers)\n>> ");
        int number;
        while(!sc.hasNextInt() || (number = sc.nextInt()) == 0) { //number is set in condition
            wrongInput(sc);
            System.out.print(">> ");
        }

        int nums[];
        if(number > 0){
            nums = scanInts(sc, number);
        }
        else{
            number*=-1;
            nums = generateInts(number);
            System.out.println("\nGenerated numbers: ");
            for (int i = 0; i < number; i++) {
                System.out.println(nums[i]);
            }
        }

        Integer dfNum = nums[0];
        boolean isDfDigit = true;
        for (int i = 0; i < nums.length; i++) {
            dfNum = nums[i];
            char[] dfNumStr = dfNum.toString().toCharArray();
            isDfDigit = true;
            for (int j = 0; j < dfNumStr.length; j++)
                for (int k = j + 1; k < dfNumStr.length; k++) {
                    if (dfNumStr[j] == dfNumStr[k])
                        isDfDigit = false;
                }
            if (isDfDigit) { //searching only for first number with different digits
                break;
            }
        }

        /*If there are no number with different digits,
         bool var will be 'false', otherwise it's will breaks with 'true'*/
        if(isDfDigit){
            System.out.println("\nFirst number with all different digits is '" + dfNum + "'.");
        }
        else {
            System.out.println("\nThere are no numbers with all different digits.");
        }
    }
    /*Ввести с консоли n-размерность матрицы a [n] [n]. Задать
    значения элементов матрицы в интервале значений от -n до n
    с помощью датчика случайных чисел.
    Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки*/
    /**Part C of the second lab. Generate matrix and rotate it*/
    private static void labSecondPart(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter matrix dimension.\n>> ");
        int dim;
        while(!sc.hasNextInt() || (dim = sc.nextInt()) <= 0) { //dim is set in condition
            wrongInput(sc);
            System.out.print(">> ");
        }

        Random rand = new Random();
        int matrix[][] = new int[dim][dim];
        for(int i = 0; i < dim; i++) {//filling matrix with random numbers
            for (int j = 0; j < dim; j++) {
                matrix[i][j] = rand.nextInt(2 * dim + 1) - dim;//random numbers from -dim to dim
            }
        }

        System.out.println("\nOriginal Matrix:");
        printMatrix(matrix);

        System.out.println("\nMatrix rotated 90 degrees:");
        rotateMatrix90CounterClockwise(matrix);
        printMatrix(matrix);

        System.out.println("\nMatrix rotated 180 degrees:");
        rotateMatrix90CounterClockwise(matrix);
        printMatrix(matrix);

        System.out.println("\nMatrix rotated 270 degrees:");
        rotateMatrix90CounterClockwise(matrix);
        printMatrix(matrix);
    }

    /**Output of matrix
     * @param matrix n*m matrix, that should be filled with values*/
    private static void printMatrix(int matrix[][]){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }
    /**Rotate the matrix clockwise
     * @param matrix n*n matrix, that should be filled with values*/
    private static void rotateMatrix90CounterClockwise(int matrix[][]){
        int tempMatrix[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tempMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[matrix[i].length - 1 - i][j] = tempMatrix[j][i];
            }
        }
    }

    /**Function that get input using scanner lib
     * @param sc - scanner object
     * @param length - amount of numbers, that should be scanned
     * @return return an int array*/
    private static int[] scanInts(Scanner sc, int length) {
        if (length < 0){
            log.error("Negative array length");
            throw new IllegalArgumentException();
        }

        int nums[] = new int[length];
        System.out.println("\nEnter " + length + " numbers.");
        for(int i = 0; i < length; i++) {
            try {
                System.out.print(">> ");
                nums[i] = sc.nextInt();
            }
            catch (Exception ex) {
                wrongInput(sc);
                i--; //return to the start of iteration
            }
        }
        return nums;
    }
    /**Generate array of int values
     * @param length - amount of generated numbers
     * @return return an array of generated numbers*/
    private static int[] generateInts(int length){
        if (length < 0){
            log.error("Negative array length");
            throw new IllegalArgumentException();
        }

        int nums[] = new int[length];
        Random rand = new Random();
        for(int i = 0; i < length; i++) {
            nums[i] = rand.nextInt();
        }
        return nums;
    }
    /**Move scanner to the next line and report a warning at log4j
     * @param sc - scanner object*/
    private static void wrongInput(Scanner sc){
        sc.nextLine();
        log.warn("Wrong int input.");
        System.out.println("Input error.");
    }
}
