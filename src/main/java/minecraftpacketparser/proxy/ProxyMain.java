package minecraftpacketparser.proxy;

import java.io.IOException;
import java.net.ServerSocket;

public class ProxyMain {

    public static int proxyPort;
    public static String mcServerIP;
    public static int mcServerPort;

    public static void main(String[] args) throws IOException {
        if(args.length != 3) {
            System.out.println("Args: proxyPort MCServerIP MCServerPort");
        }

        proxyPort = Integer.parseInt(args[0]);
        mcServerIP = args[1];
        mcServerPort = Integer.parseInt(args[2]);

        ServerSocket socket = new ServerSocket(proxyPort);
        while(!socket.isClosed()) {
            new ClientConnectionHandler(socket.accept()).start();
        }
    }

}
