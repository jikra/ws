package cz.cizek.rest.client.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloService {

    private static final String TEST_URL = "http://localhost:8989/api/hello/helloWorld";

    public static void main(String[] args) {
        test();
    }

    private static void test() {

        try {
            URL testUrl = new URL(TEST_URL);

            HttpURLConnection connection = (HttpURLConnection) testUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            connection.getResponseCode();
            System.out.println(Util.getResult(connection));

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
