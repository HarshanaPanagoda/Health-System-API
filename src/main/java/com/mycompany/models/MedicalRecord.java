package com.mycompany.models;

public class MedicalRecord {
    private long id;
    private Patient patient;
    private String diagnosis;
    private String treatment;

    // Constructor
    public MedicalRecord(long id, Patient patient, String diagnosis, String treatment) {
        this.id = id;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
