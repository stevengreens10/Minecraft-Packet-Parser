package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ChatMessageClientBoundParser extends AbstractPacketParser implements PacketParser {

    public ChatMessageClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0E", "ChatMessageClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Chat Message");
        String message = Parser.parseChat(data);
        result.packetFields.put("Chat message (JSON)", message);
        return result;
    }
}
