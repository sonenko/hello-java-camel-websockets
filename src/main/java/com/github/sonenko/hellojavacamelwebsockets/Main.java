package com.github.sonenko.hellojavacamelwebsockets;

import org.apache.camel.CamelContext;
import org.apache.camel.component.websocket.WebsocketComponent;
import org.apache.camel.builder.*;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
  public static void main(String args[]) throws Exception {
    CamelContext context = new DefaultCamelContext();
    WebsocketComponent wc = context.getComponent("websocket", WebsocketComponent.class);
    wc.setPort(8081);
    // serve static resources
    wc.setStaticResources("classpath:.");

    RouteBuilder routes = new RouteBuilder() {
      public void configure() {
        from("file:FROM").to("websocket:my-socket?sendToAll=true");
        from("websocket:my-socket").to("file:TO");
      }
    };

    context.addRoutes(routes);
    context.start();
  }
}