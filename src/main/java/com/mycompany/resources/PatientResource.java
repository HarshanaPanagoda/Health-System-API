package com.mycompany.resources;

import com.mycompany.dao.PatientDAO;
import com.mycompany.models.Patient;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {
    private static final Logger logger = LoggerFactory.getLogger(PatientResource.class);
    private final PatientDAO patientDAO = new PatientDAO();
    
    @POST
    public Response addPatient(Patient patient) {
        patientDAO.addPatient(patient);
        logger.info("Added patient with ID: {}", patient.getId());
        return Response.status(Response.Status.CREATED).entity(patient).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getPatientById(@PathParam("id") long id) {
        Patient patient = patientDAO.getPatientById(id);
        if (patient != null) {
            logger.info("Retrieved patient with ID: {}", id);
            return Response.status(Response.Status.OK).entity(patient).build();
        } else {
            logger.warn("Patient with ID {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") long id, Patient patient) {
        patient.setId(id);
        patientDAO.updatePatient(patient);
        logger.info("Updated patient with ID: {}", id);
        return Response.status(Response.Status.OK).entity(patient).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") long id) {
        patientDAO.deletePatient(id);
        logger.info("Deleted patient with ID: {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
