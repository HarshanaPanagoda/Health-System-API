package com.mycompany.models;

public class Doctor extends Person {
    private String specialization;
    
    // Constructor
    public Doctor(long id, String name, String contactInformation, String address, String specialization) {
        super(id, name, contactInformation, address);
        this.specialization = specialization;
    }
    
    // Getters and Setters
    public String getSpecialization() {
        return specialization;
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
