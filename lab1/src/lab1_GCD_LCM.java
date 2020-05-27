import java.util.Scanner;

public class lab1_GCD_LCM {
    public static void main(String[] args) {
        //read from console
        Scanner sc = new Scanner(System.in);
        //entering num and input check
        System.out.print("------\nTo find GCD & LCD enter number of numbers: ");
        int n = 0;
        while (!sc.hasNextInt() || (n = sc.nextInt()) <= 0) {
            sc.nextLine();
            System.out.print("Input Error. Try again: ");
        }

        //numbers input
        int nums[] = numsInput(sc, n);

        //calculating all gcd and lcd
        int f_gcd = nums[0], f_lcd = nums[0];
        for(int i = 1; i < n; i++) {
            f_gcd = gcd(f_gcd, nums[i]);
            f_lcd = lcd(f_lcd, nums[i]);
        }

        //final output
        System.out.println("\nGCD of this numbers is " + f_gcd
            + "\nLCD of this numbers is " + f_lcd
            + "\n------");

        //closing and clean
        sc.close();
    }
    
    //numbers input
    private static int[] numsInput(Scanner sc, int n) {
        System.out.println();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            //check of proper int input
            try {
                nums[i] = sc.nextInt();
            }
            catch (Exception e) {
                sc.nextLine();
                System.out.print("Try again. ");
                i--;
            }
        }
        return nums;
    }

    //recursive gcd
    private static int gcd (int a, int b) {
        return (a == 0) ? b : gcd(b % a, a);
    }

    private static int lcd(int a, int b) {
        return a*b / gcd(a, b);
    }
}