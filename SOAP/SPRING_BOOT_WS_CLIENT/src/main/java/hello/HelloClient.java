
package hello;

import hello.wsdl.GetGreetingResponse;
import hello.wsdl.GetNameRequest;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class HelloClient extends WebServiceGatewaySupport {

	public GetGreetingResponse getGreeting(String name) {

		GetNameRequest request = new GetNameRequest();
		request.setName(name);

		GetGreetingResponse response = (GetGreetingResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/hello", request);

		return response;
	}

}
