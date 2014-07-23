package movie;

import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class MovieEndpoint {
    @OnMessage
    public void message(String message, Session client) throws IOException, EncodeException {
        System.out.println("message: " + message + ", found " + (client.getOpenSessions().size() - 1) + " other sessions");
        client.getBasicRemote().sendText(message);
    }
}