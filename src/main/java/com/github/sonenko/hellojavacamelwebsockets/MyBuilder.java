package com.github.sonenko.hellojavacamelwebsockets;

import org.apache.camel.component.websocket.WebsocketComponent;
import org.apache.camel.builder.*;

public class MyBuilder extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    // configure web socket
    WebsocketComponent wc = getContext().getComponent("websocket", WebsocketComponent.class);
    wc.setPort(8081);
    // serve satic resources
    wc.setStaticResources("classpath:.");

    from("file:FROM").to("websocket:my-socket?sendToAll=true");

    from("websocket:my-socket").to("file:TO");
  }
}