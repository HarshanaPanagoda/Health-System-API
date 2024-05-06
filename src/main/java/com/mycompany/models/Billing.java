package com.mycompany.models;

public class Billing {
    private long id;
    private Patient patient;
    private double amount;
    private boolean isPaid;
    
    // Constructor
    public Billing(long id, Patient patient, double amount, boolean isPaid) {
        this.id = id;
        this.patient = patient;
        this.amount = amount;
        this.isPaid = isPaid;
    }
    
    // Getters and Setters
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public boolean isPaid() {
        return isPaid;
    }
    
    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
