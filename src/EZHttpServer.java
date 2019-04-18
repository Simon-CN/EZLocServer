import com.sun.net.httpserver.HttpServer;
import http_handler.TrainHandler;
import http_handler.UploadHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

class EZHttpServer {
    private static HttpServer ezServer;

    static void start() throws IOException {
        start(2333);
    }

    private static void start(int port) throws IOException {
        ezServer = HttpServer.create(new InetSocketAddress(port), 0);
        ezServer.createContext(TrainHandler.getUri(), TrainHandler.getInstance());
        ezServer.createContext(UploadHandler.getUri(), UploadHandler.getInstance());
        //ezServer.createContext(TrainHandler.getUri(), LocHandler.getInstance());
        ezServer.start();
    }

    static void stop() {
        ezServer.stop(2);
    }

}
