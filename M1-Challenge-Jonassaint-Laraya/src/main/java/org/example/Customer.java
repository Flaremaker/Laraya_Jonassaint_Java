package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int total = 0;
        for(AccountRecord bal : this.charges){
            total += bal.getCharge();
        }
        return total;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        return "Id: " + this.getId() + " Name: " + this.getName() + " Balance: " + this.getBalance();
    }
}
