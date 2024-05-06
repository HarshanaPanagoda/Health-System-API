package com.mycompany.dao;

import com.mycompany.models.Doctor;

import java.util.HashMap;
import java.util.Map;

public class DoctorDAO {
    private final Map<Long, Doctor> doctorMap = new HashMap<>();

    public DoctorDAO() {
        // Initialize with sample doctors
        Doctor doctor1 = new Doctor(1, "Dr. Smith", "9876543210", "456 Oak St", "Cardiology");
        Doctor doctor2 = new Doctor(2, "Dr. Johnson", "1231231234", "789 Maple St", "Dermatology");

        doctorMap.put(doctor1.getId(), doctor1);
        doctorMap.put(doctor2.getId(), doctor2);
    }

    public void addDoctor(Doctor doctor) {
        doctorMap.put(doctor.getId(), doctor);
    }

    public Doctor getDoctorById(long id) {
        return doctorMap.get(id);
    }

    public void updateDoctor(Doctor doctor) {
        if (doctorMap.containsKey(doctor.getId())) {
            doctorMap.put(doctor.getId(), doctor);
        }
    }

    public void deleteDoctor(long id) {
        doctorMap.remove(id);
    }
}
