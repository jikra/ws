package cz.cizek.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "cz.cizek.ws.SayHelloPT")
public class HelloWorld implements SayHelloPT {

    @Override
    public SayHelloResponse sayHello(SayHelloRequest parameters) {

        SayHelloResponse sayHelloResponse = new SayHelloResponse();

        sayHelloResponse.setGreeting("AHOJ");

        return sayHelloResponse;
    }
}
