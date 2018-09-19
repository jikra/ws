package cz.cizek.rest.client.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Util {

    public static String getResult(final HttpURLConnection connection) throws IOException {
        String output;
        BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

        String result = "";
        while ((output = br.readLine()) != null) {
            result += output;
        }
        return result;
    }
}
