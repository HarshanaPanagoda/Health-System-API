package com.mycompany.dao;

import com.mycompany.models.Appointment;
import com.mycompany.models.Doctor;
import com.mycompany.models.Patient;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppointmentDAO {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentDAO.class);
    private static AppointmentDAO instance;  // Singleton instance
    private final Map<Long, Appointment> appointmentMap = new HashMap<>();

    public AppointmentDAO() {
        // Initialize with sample appointments
        Doctor doctor1 = new Doctor(1, "Dr. Smith", "555-987-6543", "456 Oak St, Anytown, USA", "Cardiology");
        Doctor doctor2 = new Doctor(2, "Dr. Johnson", "555-333-4444", "101 Pine St, Othertown, USA", "Pediatrics");
        Patient patient1 = new Patient(1, "John Doe", "555-123-4567", "123 Main St, Anytown, USA", "Hypertension", "Stable");
        Patient patient2 = new Patient(2, "Bob Anderson", "555-111-2222", "89 Maple St, Othertown, USA", "Type 1 Diabetes", "Improving");

        Appointment appointment1 = new Appointment(1, "2024-05-07", "10:00 AM", patient1, doctor1);
        Appointment appointment2 = new Appointment(2, "2024-05-08", "11:00 AM", patient2, doctor2);

        appointmentMap.put(appointment1.getId(), appointment1);
        appointmentMap.put(appointment2.getId(), appointment2);
    }

    public static synchronized AppointmentDAO getInstance() {
        if (instance == null) {
            instance = new AppointmentDAO();
        }
        return instance;
    }

    public Collection<Appointment> getAllAppointments() {
        return appointmentMap.values();
    }

    public void addAppointment(Appointment appointment) {
        if (!appointmentMap.containsKey(appointment.getId())) {
            appointmentMap.put(appointment.getId(), appointment);
            logger.info("Successfully added appointment with ID: {}", appointment.getId());
        } else {
            logger.error("An appointment with ID {} already exists and was not added.", appointment.getId());
        }
    }

    public Appointment getAppointmentById(long id) {
        return appointmentMap.get(id);
    }

    public boolean updateAppointment(Appointment appointment) {
        if (appointmentMap.containsKey(appointment.getId())) {
            appointmentMap.put(appointment.getId(), appointment);
            return true;
        }
        return false;
    }

    public boolean deleteAppointment(long id) {
        if (appointmentMap.containsKey(id)) {
            appointmentMap.remove(id);
            return true;
        }
        return false;
    }
}
