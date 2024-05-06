package com.mycompany.dao;

import com.mycompany.models.MedicalRecord;
import java.util.HashMap;
import java.util.Map;

public class MedicalRecordDAO {
    private final Map<Long, MedicalRecord> medicalRecordMap = new HashMap<>();
    
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordMap.put(medicalRecord.getId(), medicalRecord);
    }
    
    public MedicalRecord getMedicalRecordById(long id) {
        return medicalRecordMap.get(id);
    }
    
    public void updateMedicalRecord(MedicalRecord medicalRecord) {
        if (medicalRecordMap.containsKey(medicalRecord.getId())) {
            medicalRecordMap.put(medicalRecord.getId(), medicalRecord);
        }
    }
    
    public void deleteMedicalRecord(long id) {
        medicalRecordMap.remove(id);
    }
}
