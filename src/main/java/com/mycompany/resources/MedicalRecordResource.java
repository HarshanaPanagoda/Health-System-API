package com.mycompany.resources;

import com.mycompany.dao.MedicalRecordDAO;
import com.mycompany.models.MedicalRecord;
import java.util.Collection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/medicalrecords")
@Produces(MediaType.APPLICATION_JSON)
public class MedicalRecordResource {
    private static final Logger logger = LoggerFactory.getLogger(MedicalRecordResource.class);
    private final MedicalRecordDAO medicalRecordDAO = MedicalRecordDAO.getInstance();

    @GET
    public Collection<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.getAllMedicalRecords();
    }

    @GET
    @Path("/{id}")
    public Response getMedicalRecordById(@PathParam("id") long id) {
        MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(id);
        if (medicalRecord != null) {
            return Response.ok(medicalRecord).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordDAO.addMedicalRecord(medicalRecord);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateMedicalRecord(@PathParam("id") long id, MedicalRecord medicalRecord) {
        medicalRecord.setId(id);
        if (medicalRecordDAO.updateMedicalRecord(medicalRecord)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMedicalRecord(@PathParam("id") long id) {
        if (medicalRecordDAO.deleteMedicalRecord(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
