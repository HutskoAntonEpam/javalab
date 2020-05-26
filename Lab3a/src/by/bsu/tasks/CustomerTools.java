package by.bsu.tasks;

import java.util.Scanner;

public class CustomerTools {
    public static void inputCustomer(Customer cust) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        cust.setSurname(input.nextLine());
        System.out.print("Введите имя: ");
        cust.setName(input.nextLine());
        System.out.print("Введите отчество: ");
        cust.setFathersName(input.nextLine());
        System.out.print("Введите адрес: ");
        cust.setAddress(input.nextLine());
        System.out.print("Введите номер карты: ");
        cust.setCardNumber(input.nextLong());
        System.out.print("Введите номер счета: ");
        cust.setBankAccountNumber(input.nextLong());
    }

    public static void inputArray(Customer[] arr) {
        System.out.println("Введите массив объектов:\n");
        for (int i = 0; i < arr.length; ++i) {
            System.out.println("Введите " + i + "-ый элемент:");
            arr[i] = new Customer();
            CustomerTools.inputCustomer(arr[i]);
            System.out.println();
        }
    }

    private static boolean comp(Customer c1, Customer c2) {
        if (c1.getSurname().compareTo(c2.getSurname()) < 0)
            return false;
        else if ((c1.getSurname().compareTo(c2.getSurname()) == 0) && (c1.getName().compareTo(c2.getName()) < 0))
            return false;
        else if ((c1.getSurname().compareTo(c2.getSurname()) == 0) && (c1.getName().compareTo(c2.getName()) == 0) && (c1.getFathersName().compareTo(c2.getFathersName()) < 0))
            return false;
        return true;
    }

    public static void sortAlphabetOrder(Customer[] arr) {
        boolean flag;
        for (int i = 0; i < (arr.length - 1); ++i) {
            flag = true;
            for (int j = 0; j < (arr.length - 1 - i); ++j) {
                if (comp(arr[j], arr[j + 1])) {
                    Customer tmp = new Customer(arr[j]);
                    arr[j] = new Customer(arr[j + 1]);
                    arr[j + 1] = new Customer(tmp);
                    flag = false;
                }
            }
            if (flag)
                break;
        }
    }
}