package minecraftpacketparser.proxy;

import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.Parser;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientConnectionHandler extends Thread{

    Socket clientConn;
    Socket serverConn;
    Parser parser;

    public ClientConnectionHandler(Socket conn) {
        this.clientConn = conn;
        try {
            this.parser = new Parser(new PrintStream(new File("result.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            createServerConnection();

            InputStream clientIn = clientConn.getInputStream();
            OutputStream serverStream = serverConn.getOutputStream();

            while(!clientConn.isClosed()) {
                ByteArrayOutputStream outgoing = parser.parseSocketPacket(clientIn, Direction.SERVERBOUND);
                outgoing.writeTo(serverStream);
                serverStream.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientConn.close();
                if(serverConn != null)
                    serverConn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createServerConnection() throws IOException {
        serverConn = new Socket();
        serverConn.connect(new InetSocketAddress(ProxyMain.mcServerIP, ProxyMain.mcServerPort));

        new ServerConnectionHandler(serverConn, clientConn, parser).start();
    }
}
