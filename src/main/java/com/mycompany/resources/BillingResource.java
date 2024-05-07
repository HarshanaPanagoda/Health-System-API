package com.mycompany.resources;

import com.mycompany.dao.BillingDAO;
import com.mycompany.models.Billing;
import java.util.Collection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/billings")
@Produces(MediaType.APPLICATION_JSON)
public class BillingResource {
    private static final Logger logger = LoggerFactory.getLogger(BillingResource.class);
    private final BillingDAO billingDAO = BillingDAO.getInstance();

    @GET
    public Collection<Billing> getAllBillings() {
        logger.info("Getting all bills");
        return billingDAO.getAllBillings();
    }

    @GET
    @Path("/{id}")
    public Response getBillingById(@PathParam("id") long id) {
        logger.info("Getting bills with ID {}", id);
        Billing billing = billingDAO.getBillingById(id);
        if (billing != null) {
            logger.info("Bills found with ID {}: {}", id, billing);
            return Response.ok(billing).build();
        } else {
            logger.warn("Bills not found with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addBilling(Billing billing) {
        logger.info("Adding new bill {}", billing);
        billingDAO.addBilling(billing);
        logger.info("Billing added successfully: {}", billing);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBilling(@PathParam("id") long id, Billing billing) {
        logger.info("Updating bills with ID {}", id);
        billing.setId(id);
        if (billingDAO.updateBilling(billing)) {
            logger.info("Billing updated successfully with ID {}: {}", id, billing);
            return Response.ok().build();
        } else {
            logger.warn("Failed to update billing with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBilling(@PathParam("id") long id) {
        logger.info("Deleting billing with ID {}", id);
        if (billingDAO.deleteBilling(id)) {
            logger.info("Billing deleted successfully with ID {}", id);
            return Response.ok().build();
        } else {
            logger.warn("Failed to delete billing with ID {}", id);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
