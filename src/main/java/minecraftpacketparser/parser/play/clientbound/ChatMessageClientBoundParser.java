package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ChatMessageClientBoundParser extends AbstractPacketParser implements PacketParser {

    public ChatMessageClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0F", "ChatMessageClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Chat Message", State.PLAY);
        String message = Parser.parseChat(data);
        result.packetFields.put("Chat message (JSON)", message);
        return result;
    }
}
