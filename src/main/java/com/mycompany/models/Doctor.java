package com.mycompany.models;

// Extend the Person class to represent a Doctor with additional attributes
public class Doctor extends Person {
    private String specialization;

    // Constructor
    public Doctor(long id, String name, String contactInformation, String address,
                  String specialization) {
        super(id, name, contactInformation, address);
        this.specialization = specialization;
    }

    // Getters and setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
