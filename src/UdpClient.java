import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        DatagramSocket skt = null;
        try {
            skt = new DatagramSocket(0);
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }
        InetAddress host = null;
        try {
            host = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return;
        }
        int port = 2334;
        Scanner sc = new Scanner(System.in);
        String in;
        while (true) {
            in = sc.nextLine();
            if(in.equals("quit"))
                break;
            DatagramPacket request = new DatagramPacket(in.getBytes(), in.length(), host, port);
            try {
                skt.send(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
