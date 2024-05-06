package com.mycompany.resources;

import com.mycompany.dao.PersonDAO;
import com.mycompany.models.Person;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    private static final Logger logger = LoggerFactory.getLogger(PersonResource.class);
    private final PersonDAO personDAO = new PersonDAO();
    
    @POST
    public Response addPerson(Person person) {
        personDAO.addPerson(person);
        logger.info("Added person with ID: {}", person.getId());
        return Response.status(Response.Status.CREATED).entity(person).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") long id) {
        Person person = personDAO.getPersonById(id);
        if (person != null) {
            logger.info("Retrieved person with ID: {}", id);
            return Response.status(Response.Status.OK).entity(person).build();
        } else {
            logger.warn("Person with ID {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") long id, Person person) {
        person.setId(id);
        personDAO.updatePerson(person);
        logger.info("Updated person with ID: {}", id);
        return Response.status(Response.Status.OK).entity(person).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") long id) {
        personDAO.deletePerson(id);
        logger.info("Deleted person with ID: {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
