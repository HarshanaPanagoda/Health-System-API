package com.mycompany.dao;

import com.mycompany.models.Patient;

import java.util.HashMap;
import java.util.Map;

public class PatientDAO {
    private final Map<Long, Patient> patientMap = new HashMap<>();

    public PatientDAO() {
        // Initialize with sample patients
        Patient patient1 = new Patient(1, "John Doe", "1234567890", "123 Main St", "Heart condition", "Stable");
        Patient patient2 = new Patient(2, "Jane Smith", "0987654321", "456 Elm St", "Allergies", "Under observation");

        patientMap.put(patient1.getId(), patient1);
        patientMap.put(patient2.getId(), patient2);
    }

    public void addPatient(Patient patient) {
        patientMap.put(patient.getId(), patient);
    }

    public Patient getPatientById(long id) {
        return patientMap.get(id);
    }

    public void updatePatient(Patient patient) {
        if (patientMap.containsKey(patient.getId())) {
            patientMap.put(patient.getId(), patient);
        }
    }

    public void deletePatient(long id) {
        patientMap.remove(id);
    }
}
