package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PluginMessageServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PluginMessageServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0B", "PluginMessageServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Plugin Message");
        result.packetFields.put("Identifier", Parser.parseIdentifier(data));
        return result;
    }
}
