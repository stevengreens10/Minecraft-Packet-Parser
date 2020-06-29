package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PluginMessageServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PluginMessageServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0B", "PluginMessageServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Chat Message");
        result.packetFields.put("Identifier", Parser.parseIdentifier(data));
        return result;
    }
}
