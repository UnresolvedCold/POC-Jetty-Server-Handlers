package com.schwiftycold.poc.jettypoc.server;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;

import com.schwiftycold.poc.jettypoc.Properties;

public class MainServer {
  public static void startServer()  {
    try {

      ThreadPool threadPool = new QueuedThreadPool();
      Server server = new Server(threadPool);

      // threadPool.setName("server");
      ServerConnector connector = new ServerConnector(server);
      connector.setPort(Properties.SERVERPORT.getIntegerValue());
      
      server.setConnectors(new Connector[]{connector});
      server.setHandler(MainHandler.getInstance());

      server.start();
      server.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
