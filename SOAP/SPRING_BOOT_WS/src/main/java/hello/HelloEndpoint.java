package hello;

import cz.cizek.ws.GetGreetingResponse;
import cz.cizek.ws.GetNameRequest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloEndpoint {
	private static final String NAMESPACE_URI = "http://ws.cizek.cz";


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
	@ResponsePayload
	public GetGreetingResponse sayHello(@RequestPayload GetNameRequest request) {
		GetGreetingResponse response = new GetGreetingResponse();
		response.setGreeting("ahoj " + request.getName());

		return response;
	}
}
