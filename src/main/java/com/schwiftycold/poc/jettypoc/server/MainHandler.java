package com.schwiftycold.poc.jettypoc.server;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainHandler extends AbstractHandler {

  private static MainHandler _instance;

  public static MainHandler getInstance() {
    if (_instance == null) {
      synchronized (Handler.class) {
        if (_instance == null) {
          _instance = new MainHandler();
        }
      }
    }
    return _instance;
  }

  @Override
  public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    if ("POST".equalsIgnoreCase(baseRequest.getMethod())) {
      System.out.println("POST request received");
      Map<String, String> queryParams = new HashMap<>();

      for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();) {
        String name = e.nextElement();
        String[] values = request.getParameterValues(name);
        for (String value : values) {
          queryParams.put(name, value);
        }
      }

      System.out.println("Query params: " + queryParams);
      System.out.println("Request received: " + target);

      try {
        if (target.startsWith("/hi")) {
          response.setStatus(HttpServletResponse.SC_OK);
          response.getWriter().println("Hello World");
          baseRequest.setHandled(true);
        }
      }
      catch (Exception e) {
        e.printStackTrace();
      }

    } else if ("GET".equalsIgnoreCase(baseRequest.getMethod())) {
      System.out.println("GET request received");
    }
  }

}
