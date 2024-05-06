package com.mycompany.resources;


import com.mycompany.dao.PrescriptionDAO;
import com.mycompany.models.Prescription;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrescriptionResource {
    private static final Logger logger = LoggerFactory.getLogger(PrescriptionResource.class);
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    
    @POST
    public Response addPrescription(Prescription prescription) {
        prescriptionDAO.addPrescription(prescription);
        logger.info("Added prescription with ID: {}", prescription.getId());
        return Response.status(Response.Status.CREATED).entity(prescription).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getPrescriptionById(@PathParam("id") long id) {
        Prescription prescription = prescriptionDAO.getPrescriptionById(id);
        if (prescription != null) {
            logger.info("Retrieved prescription with ID: {}", id);
            return Response.status(Response.Status.OK).entity(prescription).build();
        } else {
            logger.warn("Prescription with ID {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response updatePrescription(@PathParam("id") long id, Prescription prescription) {
        prescription.setId(id);
        prescriptionDAO.updatePrescription(prescription);
        logger.info("Updated prescription with ID: {}", id);
        return Response.status(Response.Status.OK).entity(prescription).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") long id) {
        prescriptionDAO.deletePrescription(id);
        logger.info("Deleted prescription with ID: {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
