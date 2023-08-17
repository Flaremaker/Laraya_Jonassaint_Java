package com.company.simplecrmapi.controller;


import com.company.simplecrmapi.model.Customer;
import com.company.simplecrmapi.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    private ObjectMapper mapper = new ObjectMapper();


    @BeforeEach
    public void setUp() {
        customerRepository.deleteAll();
    }
    @Test
    public void shouldReturnCustomerPostSuccess() throws Exception {

        Customer customer = new Customer();
        customer.setId(0);
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

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(customer);

        Customer customer2 = new Customer();
        customer2.setId(0);
        customer2.setFirstName("York");
        customer2.setLastName("New");
        customer2.setEmail("email@gmail.com");
        customer2.setPhone("321-111-2323");
        customer2.setCompany("UPS");
        customer2.setAddress1("956253 unicorn lane");
        customer2.setAddress2("N/A");
        customer2.setCity("Orlando");
        customer2.setState("Florida");
        customer2.setPostalCode("134556");
        customer2.setCountry("USA");
        String outputJson = mapper.writeValueAsString(customer2);

        // ACT
        mockMvc.perform(
                        post("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }
    @Test
    public void shouldUpdateById() throws Exception {

        Customer customer = new Customer();
        customer.setId(2);
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

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(
                        put("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturnCustomerById() throws Exception {

        Customer customer = new Customer();
        customer.setId(1);
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

        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andDo(print());

    }
    @Test
    public void shouldReturnCustomerByState() throws Exception {

        Customer customer = new Customer();
        customer.setId(0);
        customer.setFirstName("York");
        customer.setLastName("New");
        customer.setEmail("email@gmail.com");
        customer.setPhone("321-111-2323");
        customer.setCompany("UPS");
        customer.setAddress1("956253 unicorn lane");
        customer.setAddress2("asdsd");
        customer.setCity("Orlando");
        customer.setState("Florida");
        customer.setPostalCode("134556");
        customer.setCountry("USA");

        customerRepository.save(customer);
       List<Customer> customer1 = new ArrayList<>();
        customer1.add(customer);

        String outputJson = mapper.writeValueAsString(customer1);
        mockMvc.perform(get("/customers/state/Florida"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deleteCustomerTest() throws Exception {
        Customer customer = new Customer();
        customer.setId(0);
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
        customer.setId(2);
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

        mockMvc.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
