package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ChatMessageServerBoundParser extends AbstractPacketParser implements PacketParser {

    public ChatMessageServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x03", "ChatMessageServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Chat Message", State.PLAY);
        String message = Parser.parseString(data);
        result.packetFields.put("Chat message", message);
        return result;
    }
}
