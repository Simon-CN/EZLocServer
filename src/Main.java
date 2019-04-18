import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.print("Training server starting...");
            EZHttpServer.start();
            System.out.print("OK!\n");

            System.out.print("Positioning server starting...");
            LocateServer.start();
            System.out.println("OK!\n");

            char cmd;
            while (true) {
                cmd = (char) System.in.read();
                if (cmd == 'q') {
                    break;
                }
            }
            EZHttpServer.stop();
            LocateServer.stop();
            System.out.println("Server stop...");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }
}
