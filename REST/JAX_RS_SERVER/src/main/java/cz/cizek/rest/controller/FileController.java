package cz.cizek.rest.controller;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Path("/files")
public class FileController {

    @GET
    @Produces("text/plain")
    public Response getTextFile() {

        File file = new File("./data/textfile.txt");

        Response.ResponseBuilder responseBuilder = Response.ok(file);
        responseBuilder.header("Content-Disposition", "attachment; filename=jmeno-souboru");

        return responseBuilder.build();
    }
    /**
     * Formulář nám pošle multipart data. soubor jako InputStream a detaily o souboru
     */
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDetails) {

        String uploadPath = "./out/" + fileDetails.getFileName();

        writeFile(file, uploadPath);

        String output = "File uploaded to " + uploadPath;

        return Response.ok(output).build();
    }

    private void writeFile(InputStream file, String path) {

        try {
            Files.copy(file, Paths.get(path));
            new File(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
