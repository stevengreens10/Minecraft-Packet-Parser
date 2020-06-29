package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class SpawnEntityParser extends AbstractPacketParser implements PacketParser {

    public SpawnEntityParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x00", "SpawnEntityParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        ParseResult result = new ParseResult("Spawn Entity", State.PLAY);
        result.packetFields.put("Entity ID", Parser.parseVarInt(data));
        result.packetFields.put("Object UUID", Parser.parseUUID(data));
        result.packetFields.put("Entity Type", Parser.parseVarInt(data));
        return result;
    }
}
