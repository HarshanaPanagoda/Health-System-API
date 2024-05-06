package com.mycompany.dao;

import com.mycompany.models.Prescription;

import java.util.HashMap;
import java.util.Map;

public class PrescriptionDAO {
    private final Map<Long, Prescription> prescriptionMap = new HashMap<>();

    public PrescriptionDAO() {
        // Initialize with sample prescriptions
        Prescription prescription1 = new Prescription(1, null, "Medicine 1", 2);
        Prescription prescription2 = new Prescription(2, null, "Medicine 2", 1);

        prescriptionMap.put(prescription1.getId(), prescription1);
        prescriptionMap.put(prescription2.getId(), prescription2);
    }

    public void addPrescription(Prescription prescription) {
        prescriptionMap.put(prescription.getId(), prescription);
    }

    public Prescription getPrescriptionById(long id) {
        return prescriptionMap.get(id);
    }

    public void updatePrescription(Prescription prescription) {
        if (prescriptionMap.containsKey(prescription.getId())) {
            prescriptionMap.put(prescription.getId(), prescription);
        }
    }

    public void deletePrescription(long id) {
        prescriptionMap.remove(id);
    }
}
