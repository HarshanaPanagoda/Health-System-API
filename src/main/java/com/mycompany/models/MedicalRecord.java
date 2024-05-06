package com.mycompany.models;

// Define the MedicalRecord class
public class MedicalRecord {
    private long id;
    private Patient patient;
    // Add more attributes as needed

    // Constructor
    public MedicalRecord(long id, Patient patient) {
        this.id = id;
        this.patient = patient;
    }

    // Getters and setters
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
}
