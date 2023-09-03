package com.schwiftycold.poc.jettypoc.client;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

import com.schwiftycold.poc.jettypoc.Properties;


public class SimpleClient {

    public static void startClient() throws Exception {
        // Instantiate and start the HttpClient object.
        HttpClient httpClient = new HttpClient();
        httpClient.start();

        // Perform a simple GET and wait for the response.
        ContentResponse response = httpClient.POST("http://localhost:"+Properties.SERVERPORT.getValue()+"/hi")
                .param("p", "value")
                .send();
        System.out.println("Client Received:" + response.getContentAsString());
    }
}
