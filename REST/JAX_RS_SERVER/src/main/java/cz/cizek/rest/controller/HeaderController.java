package cz.cizek.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/headers")
public class HeaderController {

    @GET
    public Response getHeaderParam(@HeaderParam("user-agent") String userAgent) {
        return Response.ok("user-agent: " + userAgent).build();
    }

    /**
     * Metoda vezme celou http hlavičku a potom si v ní v metodě najdeme co potřebujeme
     */
    @GET
    @Path("/context")
    public Response getHeaderParam(@Context HttpHeaders httpHeaders) {
        StringBuilder response = new StringBuilder();

        for (String header : httpHeaders.getRequestHeaders().keySet()) {
            response.append(header).append(" : ");
            for (String value : httpHeaders.getRequestHeaders().get(header)) {
                response.append("{").append(value).append("}");
            }
            response.append("</br>");
        }

        return Response.ok(response.toString()).build();
    }
}
