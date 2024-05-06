package com.mycompany.dao;

import com.mycompany.models.Prescription;
import java.util.HashMap;
import java.util.Map;

public class PrescriptionDAO {
    private final Map<Long, Prescription> prescriptionMap = new HashMap<>();
    
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
