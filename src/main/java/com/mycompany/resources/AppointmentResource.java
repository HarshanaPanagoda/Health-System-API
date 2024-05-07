package com.mycompany.resources;

import com.mycompany.dao.AppointmentDAO;
import com.mycompany.models.Appointment;
import java.util.Collection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentResource.class);
    private final AppointmentDAO appointmentDAO = AppointmentDAO.getInstance();

    @GET
    public Collection<Appointment> getAllAppointments() {
        logger.info("Getting all appointments");
        return appointmentDAO.getAllAppointments();
    }

    @GET
    @Path("/{id}")
    public Response getAppointmentById(@PathParam("id") long id) {
        logger.info("Getting appointment with ID {}", id);
        Appointment appointment = appointmentDAO.getAppointmentById(id);
        if (appointment != null) {
            logger.info("Appointment found with ID {}: {}", id, appointment);
            return Response.ok(appointment).build();
        } else {
            logger.warn("Appointment not found with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addAppointment(Appointment appointment) {
        logger.info("Adding appointment {}", appointment);
        appointmentDAO.addAppointment(appointment);
        logger.info("Appointment added successfully: {}", appointment);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAppointment(@PathParam("id") long id, Appointment appointment) {
        logger.info("Updating appointment with ID {}", id);
        appointment.setId(id);
        if (appointmentDAO.updateAppointment(appointment)) {
            logger.info("Appointment updated successfully with ID {}: {}", id, appointment);
            return Response.ok().build();
        } else {
            logger.warn("Failed to update appointment with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") long id) {
        logger.info("Deleting appointment with ID {}", id);
        if (appointmentDAO.deleteAppointment(id)) {
            logger.info("Appointment deleted successfully with ID {}", id);
            return Response.ok().build();
        } else {
            logger.warn("Failed to delete appointment with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
