package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PluginMessageClientBoundParser extends AbstractPacketParser implements PacketParser {

    public PluginMessageClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x17", "PluginMessageClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Plugin Message");
        result.packetFields.put("Identifier", Parser.parseIdentifier(data));
        return result;
    }
}
