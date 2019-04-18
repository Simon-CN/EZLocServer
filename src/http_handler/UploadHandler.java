package http_handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class UploadHandler implements HttpHandler {
    private static HttpHandler instance = null;

    public static HttpHandler getInstance() {
        if (instance == null)
            instance = new UploadHandler();
        return instance;
    }

    private UploadHandler() {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

    }

    public static String getUri() {
        return "/upload";
    }

}
