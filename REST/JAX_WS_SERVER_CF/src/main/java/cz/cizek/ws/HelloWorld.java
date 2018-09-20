package cz.cizek.ws;

import javax.jws.WebService;

/**
 * @author jikra
 */
@WebService(endpointInterface = "cz.cizek.ws.SayHelloPT")
public class HelloWorld implements SayHelloPT {

//    @Override
//    public SayHelloResponse sayHello(SayHelloRequest parameters) {
//
//        return null;
//    }

	@Override
	public SayHelloResponse sayHello(final SayHelloRequest parameters) {

		SayHelloResponse response = new SayHelloResponse();
		response.setGreeting("Hello " + parameters.getName());

		return response;
	}
}
