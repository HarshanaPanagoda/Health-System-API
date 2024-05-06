package com.mycompany.resources;

import com.mycompany.dao.DoctorDAO;
import com.mycompany.models.Doctor;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {
    private static final Logger logger = LoggerFactory.getLogger(DoctorResource.class);
    private final DoctorDAO doctorDAO = new DoctorDAO();
    
    @POST
    public Response addDoctor(Doctor doctor) {
        doctorDAO.addDoctor(doctor);
        logger.info("Added doctor with ID: {}", doctor.getId());
        return Response.status(Response.Status.CREATED).entity(doctor).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getDoctorById(@PathParam("id") long id) {
        Doctor doctor = doctorDAO.getDoctorById(id);
        if (doctor != null) {
            logger.info("Retrieved doctor with ID: {}", id);
            return Response.status(Response.Status.OK).entity(doctor).build();
        } else {
            logger.warn("Doctor with ID {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response updateDoctor(@PathParam("id") long id, Doctor doctor) {
        doctor.setId(id);
        doctorDAO.updateDoctor(doctor);
        logger.info("Updated doctor with ID: {}", id);
        return Response.status(Response.Status.OK).entity(doctor).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") long id) {
        doctorDAO.deleteDoctor(id);
        logger.info("Deleted doctor with ID: {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
