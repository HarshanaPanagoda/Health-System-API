package com.mycompany.resources;

import com.mycompany.dao.AppointmentDAO;
import com.mycompany.models.Appointment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResource {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentResource.class);
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    
    @POST
    public Response addAppointment(Appointment appointment) {
        appointmentDAO.addAppointment(appointment);
        logger.info("Added appointment with ID: {}", appointment.getId());
        return Response.status(Response.Status.CREATED).entity(appointment).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getAppointmentById(@PathParam("id") long id) {
        Appointment appointment = appointmentDAO.getAppointmentById(id);
        if (appointment != null) {
            logger.info("Retrieved appointment with ID: {}", id);
            return Response.status(Response.Status.OK).entity(appointment).build();
        } else {
            logger.warn("Appointment with ID {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response updateAppointment(@PathParam("id") long id, Appointment appointment) {
        appointment.setId(id);
        appointmentDAO.updateAppointment(appointment);
        logger.info("Updated appointment with ID: {}", id);
        return Response.status(Response.Status.OK).entity(appointment).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") long id) {
        appointmentDAO.deleteAppointment(id);
        logger.info("Deleted appointment with ID: {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
