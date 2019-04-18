import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

class LocateServer {
    private static Thread revThread = null;

    private static DatagramSocket sk = null;

    static void start() {
        start(2334);
    }

    static void start(int port) {
        revThread = new Thread(() -> {
            try {
                sk = new DatagramSocket(port);
            } catch (SocketException e) {
                e.printStackTrace();
                System.out.println("Locate server init failed...");
                return;
            }
            while (true) {
                DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                try {
                    sk.receive(request);
                    System.out.println(new String(request.getData()));
                } catch (IOException e) {
                    if(e.getMessage().equals("Socket closed"))
                        break;
                }
            }
        });
        revThread.start();
    }

    static void stop() {
        sk.close();
    }
}
