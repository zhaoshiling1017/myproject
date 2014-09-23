package controllers;


import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.Http.WebSocketFrame;
import play.mvc.WebSocketController;

public class MyWebSocket extends WebSocketController {
	public static void hello(String name) {
        outbound.send("Hello %s!", name);
    }
	
	public static void echo() {
        while(inbound.isOpen()) {
             WebSocketEvent e = await(inbound.nextEvent());
             if(e instanceof WebSocketFrame) {
                  WebSocketFrame frame = (WebSocketFrame)e;
                  if(frame.textData.equals("quit")) {
                      outbound.send("Bye!");
                      disconnect();
                  } else {
                      outbound.send("Echo: %s", frame.textData);
                  }
             }
             if(e instanceof WebSocketClose) {
                 System.out.println("Socket closed!");
             }
        }
    }
}
