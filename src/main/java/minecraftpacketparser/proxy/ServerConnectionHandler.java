package minecraftpacketparser.proxy;

import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.Parser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerConnectionHandler extends Thread{

    Socket clientConn;
    Socket serverConn;
    Parser parser;

    public ServerConnectionHandler(Socket serverConn, Socket clientConn, Parser parser) {
        this.serverConn = serverConn;
        this.clientConn = clientConn;
        this.parser = parser;
    }

    public void run() {
        try {
            InputStream serverIn = serverConn.getInputStream();
            OutputStream clientStream = clientConn.getOutputStream();

            while(!serverConn.isClosed()) {
                ByteArrayOutputStream outgoing = parser.parseSocketPacket(serverIn, Direction.CLIENTBOUND);
                outgoing.writeTo(clientStream);
                clientStream.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientConn.close();
                serverConn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
