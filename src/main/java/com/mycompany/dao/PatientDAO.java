package com.mycompany.dao;

import com.mycompany.models.Patient;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientDAO {
    private static final Logger logger = LoggerFactory.getLogger(PatientDAO.class);
    private static PatientDAO instance;  // Singleton instance
    private final Map<Long, Patient> patientMap = new HashMap<>();

    public PatientDAO() {
        // Initialize with sample patients
        Patient patient1 = new Patient(1, "John Doe", "1234567890", "123 Main St", "Heart disease", "Stable");
        Patient patient2 = new Patient(2, "Jane Smith", "0987654321", "456 Elm St", "Diabetes", "Improving");

        patientMap.put(patient1.getId(), patient1);
        patientMap.put(patient2.getId(), patient2);
    }

    // Public method to get the singleton instance
    public static synchronized PatientDAO getInstance() {
        if (instance == null) {
            instance = new PatientDAO();
        }
        return instance;
    }

    // Get all patients
    public Collection<Patient> getAllPatients() {
        return patientMap.values();
    }

    // Add a patient
    public void addPatient(Patient patient) {
        if (!patientMap.containsKey(patient.getId())) {
            patientMap.put(patient.getId(), patient);
            logger.info("Successfully added patient with ID: {}", patient.getId());
        } else {
            logger.error("A patient with ID {} already exists and was not added.", patient.getId());
        }
    }

    // Retrieve a patient by ID
    public Patient getPatientById(long id) {
        return patientMap.get(id);
    }

    // Update a patient's details
    public boolean updatePatient(Patient patient) {
        if (patientMap.containsKey(patient.getId())) {
            patientMap.put(patient.getId(), patient);
            return true;
        }
        return false;
    }

    // Delete a patient
    public boolean deletePatient(long id) {
        if (patientMap.containsKey(id)) {
            patientMap.remove(id);
            return true;
        }
        return false;
    }
}
