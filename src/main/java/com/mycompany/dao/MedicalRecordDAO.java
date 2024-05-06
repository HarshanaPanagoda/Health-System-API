package com.mycompany.dao;

import com.mycompany.models.MedicalRecord;

import java.util.HashMap;
import java.util.Map;

public class MedicalRecordDAO {
    private final Map<Long, MedicalRecord> medicalRecordMap = new HashMap<>();

    public MedicalRecordDAO() {
        // Initialize with sample medical records
        MedicalRecord record1 = new MedicalRecord(1, null, "Diagnosis 1", "Treatment 1");
        MedicalRecord record2 = new MedicalRecord(2, null, "Diagnosis 2", "Treatment 2");

        medicalRecordMap.put(record1.getId(), record1);
        medicalRecordMap.put(record2.getId(), record2);
    }

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
