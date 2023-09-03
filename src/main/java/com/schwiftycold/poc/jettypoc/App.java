package com.schwiftycold.poc.jettypoc;
import java.nio.file.Paths;

import com.schwiftycold.poc.jettypoc.client.SimpleClient;
import com.schwiftycold.poc.jettypoc.server.MainServer;
//import org.eclipse.jetty.client.ContentResponse;
import org.eclipse.jetty.client.HttpClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println("Server starting...");
        new Thread(() -> {
            try {
                MainServer.startServer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("Client starting...");
        SimpleClient.startClient();
    }
}
