package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ChatMessageServerBoundParser extends AbstractPacketParser implements PacketParser {

    public ChatMessageServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x03", "ChatMessageServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        String message = Parser.parseString(data);
        output.printf("\tChat message: %s\n", message);
        return null;
    }
}
