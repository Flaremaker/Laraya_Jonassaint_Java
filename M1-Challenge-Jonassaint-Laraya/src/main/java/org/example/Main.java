package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"},
            new String[]{"1", "Wayne Enterprises", "18000", "12-22-2021"},
            new String[]{"3", "Ace Chemical", "-48000", "01-10-2022"},
            new String[]{"3", "Ace Chemical", "-95000", "12-15-2021"},
            new String[]{"1", "Wayne Enterprises", "175000", "01-01-2022"},
            new String[]{"1", "Wayne Enterprises", "-35000", "12-09-2021"},
            new String[]{"1", "Wayne Enterprises", "-64000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "70000", "12-29-2022"},
            new String[]{"2", "Daily Planet", "56000", "12-13-2022"},
            new String[]{"2", "Daily Planet", "-33000", "01-07-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "33000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "140000", "01-25-2022"},
            new String[]{"2", "Daily Planet", "5000", "12-12-2022"},
            new String[]{"3", "Ace Chemical", "-82000", "01-03-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"}
    );

    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();
        ;
        //To check the id of customers

        List<Integer> idHolder = new ArrayList<>();
        int newCustomer = 0;
        int checkNew = 0;
        //loop through custData getting all attributes
        for (int i = 0; i < customerData.size(); i++) {

            checkNew = 0;
            String[] arr = customerData.get(i);
            int idCheck = Integer.parseInt(arr[0]);
            String customerName = arr[1];
            AccountRecord record = new AccountRecord();
            record.setCharge(Integer.parseInt(arr[2]));
            record.setChargeDate(arr[3]);


            for (int j = 0; j < idHolder.size(); j++) {
                //If returning else add new customer
                if (idHolder.get(j) == idCheck) {
                    customerList.get(j).setId(idCheck);
                    customerList.get(j).setName(customerName);
                    customerList.get(j).getCharges().add(record);
                    checkNew = 1;
                    break;
                }

            }
            //there is a new customer so it makes a new customer list
            if (checkNew == 0) {
                idHolder.add(idCheck);
                customerList.add(new Customer());
                customerList.get(newCustomer).setId(idCheck);
                customerList.get(newCustomer).setName(customerName);
                customerList.get(newCustomer).getCharges().add(record);
                newCustomer++;
            }
        }
        //prints for positive and negative
        System.out.println("Positive accounts:");
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getBalance() > 0) {
                System.out.println(customerList.get(i).toString());
            }
        }

        System.out.println("Negative accounts:");
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getBalance() < 0) {
                System.out.println(customerList.get(i).toString());
            }
        }

    }
}
