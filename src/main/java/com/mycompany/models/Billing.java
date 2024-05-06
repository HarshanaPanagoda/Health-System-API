package com.mycompany.models;

// Define the Billing class
public class Billing {
    private long id;
    private double amount;
    // Add more attributes as needed

    // Constructor
    public Billing(long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
