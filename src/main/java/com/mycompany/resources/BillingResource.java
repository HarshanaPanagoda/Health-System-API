package com.mycompany.resources;

import com.mycompany.dao.BillingDAO;
import com.mycompany.models.Billing;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/billings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {
    private static final Logger logger = LoggerFactory.getLogger(BillingResource.class);
    private final BillingDAO billingDAO = new BillingDAO();
    
    @POST
    public Response addBilling(Billing billing) {
        billingDAO.addBilling(billing);
        logger.info("Added billing with ID: {}", billing.getId());
        return Response.status(Response.Status.CREATED).entity(billing).build();
    }
    
    @GET
    @Path("/{id}")
    public Response getBillingById(@PathParam("id") long id) {
        Billing billing = billingDAO.getBillingById(id);
        if (billing != null) {
            logger.info("Retrieved billing with ID: {}", id);
            return Response.status(Response.Status.OK).entity(billing).build();
        } else {
            logger.warn("Billing with ID {} not found", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    public Response updateBilling(@PathParam("id") long id, Billing billing) {
        billing.setId(id);
        billingDAO.updateBilling(billing);
        logger.info("Updated billing with ID: {}", id);
        return Response.status(Response.Status.OK).entity(billing).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteBilling(@PathParam("id") long id) {
        billingDAO.deleteBilling(id);
        logger.info("Deleted billing with ID: {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
