package by.bsu.tasks;

public class Customer {
    private static int nextId = 0;
    private int id;
    private String surname;
    private String name;
    private String fathersName;
    private String address;
    private long cardNumber;
    private long bankAccountNumber;

    public Customer() {
        this.id = Customer.nextId++;
        this.surname = "";
        this.name = "";
        this.fathersName = "";
        this.address = "";
        this.cardNumber = 0;
        this.bankAccountNumber = 0;
    }

    public Customer(String surname, String name, String fathersName, String address, long cardNumber, long bankAccountNumber) {
        this.id = Customer.nextId++;
        this.surname = surname;
        this.name = name;
        this.fathersName = fathersName;
        this.address = address;
        if (cardNumber < 0) {
            System.out.println("Ошибка! Некорректные данные");
            System.exit(1);
        }
        this.cardNumber = cardNumber;
        if (bankAccountNumber < 0) {
            System.out.println("Ошибка! Некорректные данные");
            System.exit(1);
        }
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(Customer cust) {
        this.id = cust.id;
        this.surname = cust.surname;
        this.name = cust.name;
        this.fathersName = cust.fathersName;
        this.address = cust.address;
        this.cardNumber = cust.cardNumber;
        this.bankAccountNumber = cust.bankAccountNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        if (cardNumber < 0) {
            System.out.println("Ошибка! Некорректные данные");
            System.exit(1);
        }
        this.cardNumber = cardNumber;
    }

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(long bankAccountNumber) {
        if (bankAccountNumber < 0) {
            System.out.println("Ошибка! Некорректные данные");
            System.exit(1);
        }
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Customer{ " +
                "id = " + id +
                ", Фамилия = " + surname +
                ", Имя = " + name +
                ", Отчество = " + fathersName +
                ", Адрес = " + address +
                ", Номер карты = " + cardNumber +
                ", Номер счета = " + bankAccountNumber +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (cardNumber != customer.cardNumber) return false;
        if (bankAccountNumber != customer.bankAccountNumber) return false;
        if (surname != null ? !surname.equals(customer.surname) : customer.surname != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (fathersName != null ? !fathersName.equals(customer.fathersName) : customer.fathersName != null)
            return false;
        return address != null ? address.equals(customer.address) : customer.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fathersName != null ? fathersName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (int) (cardNumber ^ (cardNumber >>> 32));
        result = 31 * result + (int) (bankAccountNumber ^ (bankAccountNumber >>> 32));
        return result;
    }
}