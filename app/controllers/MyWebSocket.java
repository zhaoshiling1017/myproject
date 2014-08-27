package controllers;


import play.mvc.Http.WebSocketClose;
import play.mvc.Http.WebSocketEvent;
import play.mvc.Http.WebSocketFrame;
import play.mvc.WebSocketController;

public class MyWebSocket extends WebSocketController {
	public static void hello(String name) {
		System.out.println(">>>>>>>>>>"+name);
        outbound.send("Hello %s!", name);
    }
	
	public static void echo() {
		System.out.println("===================="+inbound.isOpen());
        while(inbound.isOpen()) {
             WebSocketEvent e = await(inbound.nextEvent());
             if(e instanceof WebSocketFrame) {
            	 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<");
                  WebSocketFrame frame = (WebSocketFrame)e;
                  if(frame.textData.equals("quit")) {
                      outbound.send("Bye!");
                      disconnect();
                  } else {
                	  System.out.println(">>>>>>>>>>>>>>>>>>>>"+frame.textData);
                      outbound.send("Echo: %s", frame.textData);
                  }
             }
             if(e instanceof WebSocketClose) {
                 System.out.println("Socket closed!");
             }
        }
    }
}
