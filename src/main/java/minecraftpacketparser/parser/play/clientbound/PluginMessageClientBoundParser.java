package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PluginMessageClientBoundParser extends AbstractPacketParser implements PacketParser {

    public PluginMessageClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x19", "PluginMessageClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Plugin Message");
        result.packetFields.put("Identifier", Parser.parseIdentifier(data));
        return result;
    }
}
