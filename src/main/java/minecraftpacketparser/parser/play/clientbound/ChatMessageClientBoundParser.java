package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ChatMessageClientBoundParser extends AbstractPacketParser implements PacketParser {

    public ChatMessageClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0F", "ChatMessageClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        String message = Parser.parseChat(data);
        output.printf("\tChat message (JSON): %s\n", message);
        return null;
    }
}
