package com.mycompany.dao;

import com.mycompany.models.Patient;
import com.mycompany.models.Prescription;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrescriptionDAO {
    private static final Logger logger = LoggerFactory.getLogger(PrescriptionDAO.class);
    private static PrescriptionDAO instance;  // Singleton instance
    private final Map<Long, Prescription> prescriptionMap = new HashMap<>();

    public PrescriptionDAO() {
        // Initialize with sample prescriptions
        Patient patient1 = new Patient(1, "John Doe", "1234567890", "123 Main St", "Heart disease", "Stable");
        Patient patient2 = new Patient(2, "Jane Smith", "0987654321", "456 Elm St", "Diabetes", "Improving");

        Prescription prescription1 = new Prescription(1, patient1, null, "Medication A", "1 tablet daily", "With food", "7 days");
        Prescription prescription2 = new Prescription(2, patient2, null, "Insulin", "As directed", "Before meals", "30 days");

        prescriptionMap.put(prescription1.getId(), prescription1);
        prescriptionMap.put(prescription2.getId(), prescription2);
    }

    public static synchronized PrescriptionDAO getInstance() {
        if (instance == null) {
            instance = new PrescriptionDAO();
        }
        return instance;
    }

    public Collection<Prescription> getAllPrescriptions() {
        return prescriptionMap.values();
    }

    public void addPrescription(Prescription prescription) {
        if (!prescriptionMap.containsKey(prescription.getId())) {
            prescriptionMap.put(prescription.getId(), prescription);
            logger.info("Successfully added prescription with ID: {}", prescription.getId());
        } else {
            logger.error("A prescription with ID {} already exists and was not added.", prescription.getId());
        }
    }

    public Prescription getPrescriptionById(long id) {
        return prescriptionMap.get(id);
    }

    public boolean updatePrescription(Prescription prescription) {
        if (prescriptionMap.containsKey(prescription.getId())) {
            prescriptionMap.put(prescription.getId(), prescription);
            return true;
        }
        return false;
    }

    public boolean deletePrescription(long id) {
        if (prescriptionMap.containsKey(id)) {
            prescriptionMap.remove(id);
            return true;
        }
        return false;
    }
}
