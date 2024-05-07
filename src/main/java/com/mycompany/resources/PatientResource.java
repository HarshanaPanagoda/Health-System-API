package com.mycompany.resources;

import com.mycompany.dao.PatientDAO;
import com.mycompany.models.Patient;
import java.util.Collection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
public class PatientResource {
    private static final Logger logger = LoggerFactory.getLogger(PatientResource.class);
    private final PatientDAO patientDAO = PatientDAO.getInstance();

    @GET
    public Collection<Patient> getAllPatients() {
        logger.info("Getting all patients");
        return patientDAO.getAllPatients();
    }

    @GET
    @Path("/{id}")
    public Response getPatientById(@PathParam("id") long id) {
        logger.info("Getting patient with ID {}", id);
        Patient patient = patientDAO.getPatientById(id);
        if (patient != null) {
            logger.info("Patient found with ID {}: {}", id, patient);
            return Response.ok(patient).build();
        } else {
            logger.warn("Patient not found with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addPatient(Patient patient) {
        logger.info("Adding patient {}", patient);
        patientDAO.addPatient(patient);
        logger.info("Patient added successfully: {}", patient);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") long id, Patient patient) {
        logger.info("Updating patient with ID {}", id);
        patient.setId(id);
        if (patientDAO.updatePatient(patient)) {
            logger.info("Patient updated successfully with ID {}: {}", id, patient);
            return Response.ok().build();
        } else {
            logger.warn("Failed to update patient with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") long id) {
        logger.info("Deleting patient with ID {}", id);
        if (patientDAO.deletePatient(id)) {
            logger.info("Patient deleted successfully with ID {}", id);
            return Response.ok().build();
        } else {
            logger.warn("Failed to delete patient with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
