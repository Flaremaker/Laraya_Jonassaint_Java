package com.company.simplecrmapi.repository;

import com.company.simplecrmapi.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();

    }

    //Test for create customer
    @Test
    public void findByStateTest() {
        Customer customer = new Customer();

        customer.setFirstName("York");
        customer.setLastName("New");
        customer.setEmail("email@gmail.com");
        customer.setPhone("321-111-2323");
        customer.setCompany("UPS");
        customer.setAddress1("956253 unicorn lane");
        customer.setAddress2("N/A");
        customer.setCity("Orlando");
        customer.setState("Florida");
        customer.setPostalCode("134556");
        customer.setCountry("USA");

        customerRepository.save(customer);

      List<Customer> customer1 = customerRepository.findByState(customer.getState());

        assertTrue(customer1.contains(customer));

    }

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("York");
        customer.setLastName("New");
        customer.setEmail("email@gmail.com");
        customer.setPhone("321-111-2323");
        customer.setCompany("UPS");
        customer.setAddress1("956253 unicorn lane");
        customer.setAddress2("N/A");
        customer.setCity("Orlando");
        customer.setState("Florida");
        customer.setPostalCode("134556");
        customer.setCountry("USA");


        //Act...
        customer = customerRepository.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("York");
        customer.setLastName("New");
        customer.setEmail("email@gmail.com");
        customer.setPhone("321-111-2323");
        customer.setCompany("UPS");
        customer.setAddress1("956253 unicorn lane");
        customer.setAddress2("N/A");
        customer.setCity("Orlando");
        customer.setState("Florida");
        customer.setPostalCode("134556");
        customer.setCountry("USA");

        customerRepository.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Zee");
        customer2.setLastName("Bre");
        customer2.setEmail("email2@gmail.com");
        customer2.setPhone("321-222-2323");
        customer2.setCompany("UPS");
        customer2.setAddress1("956253 yellow lane");
        customer2.setAddress2("N/A");
        customer2.setCity("Orlando");
        customer2.setState("Florida");
        customer2.setPostalCode("654321");
        customer2.setCountry("USA");

        customerRepository.save(customer2);

        List<Customer> customerList = customerRepository.findAll();

        //Assert...
        assertEquals(2, customerList.size());
    }


    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("York");
        customer.setLastName("New");
        customer.setEmail("email@gmail.com");
        customer.setPhone("321-111-2323");
        customer.setCompany("UPS");
        customer.setAddress1("956253 unicorn lane");
        customer.setAddress2("N/A");
        customer.setCity("Orlando");
        customer.setState("Florida");
        customer.setPostalCode("134556");
        customer.setCountry("USA");


        customerRepository.save(customer);

        customer.setFirstName("UPDATED");

        customerRepository.save(customer);


        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }





    @Test
    public void deleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("York");
        customer.setLastName("New");
        customer.setEmail("email@gmail.com");
        customer.setPhone("321-111-2323");
        customer.setCompany("UPS");
        customer.setAddress1("956253 unicorn lane");
        customer.setAddress2("N/A");
        customer.setCity("Orlando");
        customer.setState("Florida");
        customer.setPostalCode("134556");
        customer.setCountry("USA");

        customerRepository.save(customer);


        customerRepository.deleteById(customer.getId());


        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }
}