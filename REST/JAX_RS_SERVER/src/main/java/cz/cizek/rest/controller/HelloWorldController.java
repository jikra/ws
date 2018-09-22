package cz.cizek.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldController {

    @GET
    @Path("/helloWorld")
    public Response sayHello() {

        Response response = Response.status(Response.Status.OK).entity("Hello World").build();
        return response;
    }
}
