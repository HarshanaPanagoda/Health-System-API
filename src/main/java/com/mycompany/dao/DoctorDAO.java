package com.mycompany.dao;

import com.mycompany.models.Doctor;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoctorDAO {
    private static final Logger logger = LoggerFactory.getLogger(DoctorDAO.class);
    private static DoctorDAO instance;  // Singleton instance
    private final Map<Long, Doctor> doctorMap = new HashMap<>();

    public DoctorDAO() {
        // Initialize with sample doctors
        Doctor doctor1 = new Doctor(1, "Dr. Smiths", "1234567890", "123 Main St", "Cardiology");
        Doctor doctor2 = new Doctor(2, "Dr. Johnson", "0987654321", "456 Elm St", "Pediatrics");

        doctorMap.put(doctor1.getId(), doctor1);
        doctorMap.put(doctor2.getId(), doctor2);
    }

    public static synchronized DoctorDAO getInstance() {
        if (instance == null) {
            instance = new DoctorDAO();
        }
        return instance;
    }

    public Collection<Doctor> getAllDoctors() {
        return doctorMap.values();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctorMap.containsKey(doctor.getId())) {
            doctorMap.put(doctor.getId(), doctor);
            logger.info("Successfully added doctor with ID: {}", doctor.getId());
        } else {
            logger.error("A doctor with ID {} already exists and was not added.", doctor.getId());
        }
    }

    public Doctor getDoctorById(long id) {
        return doctorMap.get(id);
    }

    public boolean updateDoctor(Doctor doctor) {
        if (doctorMap.containsKey(doctor.getId())) {
            doctorMap.put(doctor.getId(), doctor);
            return true;
        }
        return false;
    }

    public boolean deleteDoctor(long id) {
        if (doctorMap.containsKey(id)) {
            doctorMap.remove(id);
            return true;
        }
        return false;
    }
}
