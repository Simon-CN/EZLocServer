package http_handler;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class LocHandler implements HttpHandler {
    private static HttpHandler instance = null;

    public static HttpHandler getInstance() {
        if (instance == null)
            instance = new LocHandler();
        return instance;
    }

    private LocHandler() {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

    }

    public static String getUri() {
        return "/loc";
    }

}
