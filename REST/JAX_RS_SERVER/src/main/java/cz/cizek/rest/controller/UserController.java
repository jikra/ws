package cz.cizek.rest.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.stream.Collectors;

@Path("/users")
public class UserController {

    /**
     * bez path
     */
    @GET
    public Response getUsers() {

        return Response.ok("All users").build();
    }


    /**
     * Metoda vrátí pouze VIP uživatele
     * Má definován Path takže bude na /users/vip
     */
    @GET
    @Path("/vip")
    public Response getVipUsers() {
        return Response.ok("All VIP users").build();
    }

    /**
     * path parametry
     */
    @GET
    @Path("/{year}/{month}/{day}")
    public Response getUserByBirthDate(@PathParam("year") int year,
                                       @PathParam("month") int month,
                                       @PathParam("day") int day) {
        return Response.ok("User with birthDate: " + day + "/" + month + "/" + year).build();
    }

    /**
     * metoda bere parametry z URL pomocí ?name=value&name=value
     * pokud parametr definujeme jako např. list je možné do stejné name poslat více hodnot
     * Když pošleme víc hodnot např. do firstName tak se bere 1.
     */
    @GET
    @Path("/query")
    public Response getSpecificUser(@QueryParam("firstName") List<String> firstName,
                                    @QueryParam("lastName") String lastName) {
        return Response.ok("User firstname: " + String.join(",", firstName) + " lastname: " + lastName).build();
    }

    /**
     * stejná funkcionalita jen s query u URL, ale parsuje až v kódu
     */
    @GET
    @Path("/contextquery")
    public Response getSpecificUserByContext(@Context UriInfo info) {
        String firstName = info.getQueryParameters().getFirst("firstName");
        String lastName = info.getQueryParameters().getFirst("lastName");

        return Response.ok("User firstname: " + firstName + " lastname: " + lastName).build();
    }

    /**
     * default hodnota pro query parameter
     */
    @GET
    @Path("/query2")
    public Response getSpecificUserWithDefaultValue(@DefaultValue("jmeno") @QueryParam("firstName") String firstName,
                                                    @DefaultValue("prijmeni") @QueryParam("lastName") String lastName) {
        return Response.ok("User firstname: " + firstName + " lastname: " + lastName).build();
    }

    /**
     * Metoda bere parametry z URL jako matrix param. Jako oddělovač se používá ;
     * Tedy path;key=value;key=value
     */
    @GET
    @Path("/matrix")
    public Response getSpecificUserByMatrixParam(@MatrixParam("firstName") String firstName,
                                                 @MatrixParam("lastName") String lastName) {
        return Response.ok("User firstname: " + firstName + " lastname: " + lastName).build();
    }


    /**
     * Metoda volána při potvrzení formuláře <code>pages/submitform.html</code>
     * jména parametrů odpovídají jménům input boxů.
     */
    @POST
    @Path("/form")
    public Response getFormData(@FormParam("name") String name,
                                @FormParam("age") String age) {
        return Response.ok("User name: " + name + " age: " + age).build();
    }
}
