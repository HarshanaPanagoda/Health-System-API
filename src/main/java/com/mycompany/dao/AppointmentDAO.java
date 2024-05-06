package com.mycompany.dao;

import com.mycompany.models.Appointment;
import java.util.HashMap;
import java.util.Map;

public class AppointmentDAO {
    private final Map<Long, Appointment> appointmentMap = new HashMap<>();
    
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
