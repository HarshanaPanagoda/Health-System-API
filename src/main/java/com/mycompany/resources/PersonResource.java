package com.mycompany.resources;

import com.mycompany.dao.PersonDAO;
import com.mycompany.models.Person;
import java.util.ArrayList;
import java.util.List;
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
    private final PersonDAO personDAO = PersonDAO.getInstance(); // Use singleton instance

    @GET
    public Response getAllPersons() {
        List<Person> persons = new ArrayList<>(personDAO.getAllPersons());
        if (!persons.isEmpty()) {
            logger.info("Retrieved all persons");
            return Response.status(Response.Status.OK).entity(persons).build();
        } else {
            logger.warn("No persons found");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

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
    person.setId(id); // Ensure the ID from the path is set on the person object
    boolean updated = personDAO.updatePerson(person);
    if (updated) {
        logger.info("Updated person with ID: {}", id);
        return Response.status(Response.Status.OK).entity(person).build();
    } else {
        logger.warn("Person with ID {} not found or not updated", id);
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

@DELETE
@Path("/{id}")
public Response deletePerson(@PathParam("id") long id) {
    boolean deleted = personDAO.deletePerson(id);
    if (deleted) {
        logger.info("Deleted person with ID: {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    } else {
        logger.warn("Person with ID {} not found or not deleted", id);
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

}
