package cz.cizek.ws.service;

import cz.cizek.ws.SayHelloPT;
import cz.cizek.ws.SayHelloRequest;
import cz.cizek.ws.SayHelloResponse;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloClient {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8888/soap/hi?wsdl");
        QName qName = new QName("http://ws.cizek.cz/", "HelloWorldService");

        Service service = Service.create(url, qName);
        SayHelloPT sayHelloPT = service.getPort(SayHelloPT.class);

        SayHelloRequest request = new SayHelloRequest();
        request.setName("jikra");

        SayHelloResponse response = sayHelloPT.sayHello(request);

        System.out.println(response.getGreeting());
    }

}
