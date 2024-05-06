package com.mycompany.dao;


import com.mycompany.models.Doctor;
import java.util.HashMap;
import java.util.Map;

public class DoctorDAO {
    private final Map<Long, Doctor> doctorMap = new HashMap<>();
    
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
