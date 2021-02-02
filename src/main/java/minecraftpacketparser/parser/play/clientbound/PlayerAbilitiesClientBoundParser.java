package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerAbilitiesClientBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerAbilitiesClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x30", "PlayerAbilitiesClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Abilities Client Bound");
        result.packetFields.put("Flags", Parser.parseByte(data));
        result.packetFields.put("Flying Speed", Parser.parseFloat(data));
        result.packetFields.put("Field of View Modifier", Parser.parseFloat(data));
        return result;
    }
}
