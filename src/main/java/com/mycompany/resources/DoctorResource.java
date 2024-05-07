package com.mycompany.resources;

import com.mycompany.dao.DoctorDAO;
import com.mycompany.models.Doctor;
import java.util.Collection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
public class DoctorResource {
    private static final Logger logger = LoggerFactory.getLogger(DoctorResource.class);
    private final DoctorDAO doctorDAO = DoctorDAO.getInstance();

    @GET
    public Collection<Doctor> getAllDoctors() {
        logger.info("Getting all doctors");
        return doctorDAO.getAllDoctors();
    }

    @GET
    @Path("/{id}")
    public Response getDoctorById(@PathParam("id") long id) {
        logger.info("Getting doctor with ID {}", id);
        Doctor doctor = doctorDAO.getDoctorById(id);
        if (doctor != null) {
            logger.info("Doctor found with ID {}: {}", id, doctor);
            return Response.ok(doctor).build();
        } else {
            logger.warn("Doctor not found with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addDoctor(Doctor doctor) {
        logger.info("Adding doctor {}", doctor);
        doctorDAO.addDoctor(doctor);
        logger.info("Doctor added successfully: {}", doctor);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDoctor(@PathParam("id") long id, Doctor doctor) {
        logger.info("Updating doctor with ID {}", id);
        doctor.setId(id);
        if (doctorDAO.updateDoctor(doctor)) {
            logger.info("Doctor updated successfully with ID {}: {}", id, doctor);
            return Response.ok().build();
        } else {
            logger.warn("Failed to update doctor with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") long id) {
        logger.info("Deleting doctor with ID {}", id);
        if (doctorDAO.deleteDoctor(id)) {
            logger.info("Doctor deleted successfully with ID {}", id);
            return Response.ok().build();
        } else {
            logger.warn("Failed to delete doctor with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
