package hello;

import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class ResponseErrorHandler implements org.springframework.web.client.ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return clientHttpResponse.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        System.out.println("A");
    }
}
