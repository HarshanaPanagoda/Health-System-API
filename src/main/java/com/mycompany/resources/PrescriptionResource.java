package com.mycompany.resources;

import com.mycompany.dao.PrescriptionDAO;
import com.mycompany.models.Prescription;
import java.util.Collection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
public class PrescriptionResource {
    private static final Logger logger = LoggerFactory.getLogger(PrescriptionResource.class);
    private final PrescriptionDAO prescriptionDAO = PrescriptionDAO.getInstance();

    @GET
    public Collection<Prescription> getAllPrescriptions() {
        logger.info("Getting all prescriptions");
        return prescriptionDAO.getAllPrescriptions();
    }

    @GET
    @Path("/{id}")
    public Response getPrescriptionById(@PathParam("id") long id) {
        logger.info("Getting prescription with ID {}", id);
        Prescription prescription = prescriptionDAO.getPrescriptionById(id);
        if (prescription != null) {
            logger.info("Prescription found with ID {}: {}", id, prescription);
            return Response.ok(prescription).build();
        } else {
            logger.warn("Prescription not found with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addPrescription(Prescription prescription) {
        logger.info("POST request received: Adding prescription {}", prescription);
        prescriptionDAO.addPrescription(prescription);
        logger.info("Prescription added successfully: {}", prescription);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePrescription(@PathParam("id") long id, Prescription prescription) {
        logger.info("Updating prescription with ID {}", id);
        prescription.setId(id);
        if (prescriptionDAO.updatePrescription(prescription)) {
            logger.info("Prescription updated successfully with ID {}: {}", id, prescription);
            return Response.ok().build();
        } else {
            logger.warn("Failed to update prescription with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") long id) {
        logger.info("Deleting prescription with ID {}", id);
        if (prescriptionDAO.deletePrescription(id)) {
            logger.info("Prescription deleted successfully with ID {}", id);
            return Response.ok().build();
        } else {
            logger.warn("Failed to delete prescription with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
