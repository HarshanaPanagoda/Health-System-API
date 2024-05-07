package com.mycompany.dao;

import com.mycompany.models.MedicalRecord;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedicalRecordDAO {
    private static final Logger logger = LoggerFactory.getLogger(MedicalRecordDAO.class);
    private static MedicalRecordDAO instance;  // Singleton instance
    private final Map<Long, MedicalRecord> medicalRecordMap = new HashMap<>();
    private long nextId = 1;

    private MedicalRecordDAO() {
        // Private constructor to enforce singleton pattern
    }

    public static synchronized MedicalRecordDAO getInstance() {
        if (instance == null) {
            instance = new MedicalRecordDAO();
        }
        return instance;
    }

    public Collection<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordMap.values();
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecord.setId(nextId++);
        medicalRecordMap.put(medicalRecord.getId(), medicalRecord);
        logger.info("Successfully added medical record with ID: {}", medicalRecord.getId());
    }

    public MedicalRecord getMedicalRecordById(long id) {
        return medicalRecordMap.get(id);
    }

    public boolean updateMedicalRecord(MedicalRecord medicalRecord) {
        if (medicalRecordMap.containsKey(medicalRecord.getId())) {
            medicalRecordMap.put(medicalRecord.getId(), medicalRecord);
            return true;
        }
        return false;
    }

    public boolean deleteMedicalRecord(long id) {
        if (medicalRecordMap.containsKey(id)) {
            medicalRecordMap.remove(id);
            return true;
        }
        return false;
    }
}
