package com.mycompany.dao;

import com.mycompany.models.Appointment;
import com.mycompany.models.Doctor;
import com.mycompany.models.Patient;

import java.util.HashMap;
import java.util.Map;

public class AppointmentDAO {
    private final Map<Long, Appointment> appointmentMap = new HashMap<>();

    public AppointmentDAO() {
        // Initialize with sample appointments
        Patient patient1 = new Patient(1, "John Doe", "1234567890", "123 Main St", "Heart condition", "Stable");
        Doctor doctor1 = new Doctor(1, "Dr. Smith", "9876543210", "456 Oak St", "Cardiology");
        Patient patient2 = new Patient(2, "Jane Smith", "0987654321", "456 Elm St", "Allergies", "Under observation");
        Doctor doctor2 = new Doctor(2, "Dr. Johnson", "1231231234", "789 Maple St", "Dermatology");

        Appointment appointment1 = new Appointment(1, "2024-05-06", "10:00 AM", patient1, doctor1);
        Appointment appointment2 = new Appointment(2, "2024-05-07", "11:00 AM", patient2, doctor2);

        appointmentMap.put(appointment1.getId(), appointment1);
        appointmentMap.put(appointment2.getId(), appointment2);
    }

    public void addAppointment(Appointment appointment) {
        appointmentMap.put(appointment.getId(), appointment);
    }

    public Appointment getAppointmentById(long id) {
        return appointmentMap.get(id);
    }

    public void updateAppointment(Appointment appointment) {
        if (appointmentMap.containsKey(appointment.getId())) {
            appointmentMap.put(appointment.getId(), appointment);
        }
    }

    public void deleteAppointment(long id) {
        appointmentMap.remove(id);
    }
}

