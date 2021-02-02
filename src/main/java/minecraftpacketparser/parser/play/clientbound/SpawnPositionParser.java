package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpawnPositionParser extends AbstractPacketParser implements PacketParser {

    public SpawnPositionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x42", "SpawnPositionParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Position");
        result.packetFields.put("Spawn Position", Parser.parsePosition(data));
        return result;
    }
}
