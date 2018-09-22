package cz.cizek.rest.controller;

import cz.cizek.rest.entity.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers")
public class CustomerController {

    @GET
    @Path("/xml/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer getCustomerXMLById(@PathParam("id") int id) {

        Customer customer = new Customer();

        customer.setId(id);
        customer.setAge(26);
        customer.setName("jikra");

        return customer;
    }

    @GET
    @Path("/json/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerJSONById(@PathParam("id") int id) {

        Customer customer = new Customer();

        customer.setId(id);
        customer.setAge(26);
        customer.setName("jikra");

        return customer;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addCustomer(Customer customer) {
        String result = "Customer : " + customer;

        return Response.status(201).entity(result).build();
    }
}
