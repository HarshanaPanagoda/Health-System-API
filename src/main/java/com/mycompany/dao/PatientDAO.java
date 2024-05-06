package com.mycompany.dao;

import com.mycompany.models.Patient;
import java.util.HashMap;
import java.util.Map;

public class PatientDAO {
    private final Map<Long, Patient> patientMap = new HashMap<>();
    
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
