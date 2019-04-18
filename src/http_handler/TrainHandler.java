package http_handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class TrainHandler implements HttpHandler {
    private static TrainHandler instance = null;

    public static HttpHandler getInstance() {
        if (instance == null)
            instance = new TrainHandler();
        return instance;
    }

    private TrainHandler(){}

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response="This is train response...";
        exchange.sendResponseHeaders(200,0);
        OutputStream os=exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public static String getUri() {
        return "/train";
    }
}
