import org.example.AccountRecord;
import org.example.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    Customer customer;

    @BeforeEach
    public void setUp(){
        customer = new Customer();
        AccountRecord record = new AccountRecord();
        AccountRecord recordTwo = new AccountRecord();
        record.setCharge(100);
        recordTwo.setCharge(200);
        customer.getCharges().add(record);
        customer.getCharges().add(recordTwo);
        customer.setId(5);
        customer.setName("Harry");

    }

    @Test
    public void getBalanceShouldWork() {
        assertEquals(300 ,customer.getBalance());
    }

    @Test
    public void stringTest(){

        String testString = "Id: " + customer.getId() + " Name: " + customer.getName() + " Balance: " + customer.getBalance();

        assertEquals(testString,customer.toString());


    }


}