package test.bsu.tasks.CustomerTests;

import by.bsu.tasks.Customer;
import by.bsu.tasks.CustomerTools;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerToolsTests {

    @Test
    public void sortAlphabetOrderTest() {
        Customer[] actual = new Customer[3];
        Customer[] expected = new Customer[3];
        Customer customer = new Customer();
        customer.setSurname("Alekssev");
        customer.setName("Alex");
        customer.setFathersName("Aleksandrovich");
        expected[0] = new Customer(customer);
        actual[1] = new Customer(customer);
        customer = new Customer();
        customer.setSurname("Martinevski");
        customer.setName("Denis");
        customer.setFathersName("Aleksandrovich");
        expected[2] = new Customer(customer);
        actual[0] = new Customer(customer);
        customer = new Customer();
        customer.setSurname("Livanov");
        customer.setName("Serj");
        customer.setFathersName("Olegovich");
        expected[1] = new Customer(customer);
        actual[2] = new Customer(customer);
        CustomerTools.sortAlphabetOrder(actual);
        Assert.assertEquals(actual, expected);
    }
}
