package com.mycompany.resources;

import com.mycompany.dao.MedicalRecordDAO;
import com.mycompany.models.MedicalRecord;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/medicalrecords")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalRecordResource {
    private static final Logger logger = LoggerFactory.getLogger(MedicalRecordResource.class);
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
    
    @POST
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.addMedicalRecord(medicalRecord);
        logger.info("Added medical record with ID: {}", medicalRecord.getId());
        return Response.status(Response.Status.CREATED).entity(medicalRecord).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getMedicalRecordById(@PathParam("id") long id) {
        MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(id);
        if (medicalRecord != null) {
            logger.info("Retrieved medical record with ID: {}", id);
            return Response.status(Response.Status.OK).entity(medicalRecord).build();
        } else {
            logger.warn("Medical record with ID {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response updateMedicalRecord(@PathParam("id") long id, MedicalRecord medicalRecord) {
        medicalRecord.setId(id);
        medicalRecordDAO.updateMedicalRecord(medicalRecord);
        logger.info("Updated medical record with ID: {}", id);
        return Response.status(Response.Status.OK).entity(medicalRecord).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteMedicalRecord(@PathParam("id") long id) {
        medicalRecordDAO.deleteMedicalRecord(id);
        logger.info("Deleted medical record with ID: {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
