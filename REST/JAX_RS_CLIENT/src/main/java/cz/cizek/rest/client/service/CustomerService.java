package cz.cizek.rest.client.service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cz.cizek.rest.client.entity.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class CustomerService {

    private static final String SERVER_URL_POST_XML = "http://localhost:8989/api/customers/add";
    private static final String SERVER_URL_GET_XML = "http://localhost:8989/api/customers/xml/12";
    private static final String SERVER_URL_GET_JSON = "http://localhost:8989/api/customers/json/12";

    public static void main(String[] args) {

        String xmlResource = getResource("application/xml", SERVER_URL_GET_XML);
        System.out.println(xmlResource);
        System.out.println(unmarshall(xmlResource).toString());


        Customer customer = new Customer();
        customer.setName("jikra");
        customer.setId(123);
        customer.setAge(26);

        System.out.println("Posíláme objekt: " + customer);
        System.out.println(addCustomer(customer));
    }

    private static String getResource(String contentType, String URL) {

        Client client = Client.create();
        WebResource webResource = client.resource(URL);
        ClientResponse response = webResource.accept(contentType).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        String output = response.getEntity(String.class);
        return output;
    }

    private static Customer unmarshall(String source) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(source);
            Customer customer = (Customer) unmarshaller.unmarshal(reader);

            return customer;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String addCustomer(Customer customer) {

        Client client = Client.create();
        WebResource webResource = client.resource(SERVER_URL_POST_XML);

        ClientResponse response = webResource.type("application/xml").post(ClientResponse.class, customer);

        if (response.getStatus() != 201) {
            throw new RuntimeException("Http failed with code: " + response.getStatus());
        }

        String output = response.getEntity(String.class);
        return output;
    }
}
