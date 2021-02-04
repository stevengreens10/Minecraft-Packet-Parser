package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SpawnPositionParser extends AbstractPacketParser implements PacketParser {

    public SpawnPositionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x42", "SpawnPositionParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Position");
        result.packetFields.put("Spawn Position", Parser.parsePosition(data));
        return result;
    }
}
