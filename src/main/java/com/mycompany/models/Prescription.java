package com.mycompany.models;

// Define the Prescription class
public class Prescription {
    private long id;
    private String medication;
    private int dosage;
    // Add more attributes as needed

    // Constructor
    public Prescription(long id, String medication, int dosage) {
        this.id = id;
        this.medication = medication;
        this.dosage = dosage;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
}
