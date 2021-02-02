package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerPosAndLookClientBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerPosAndLookClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x34", "PlayerPosAndLookClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Position and Look");
        result.packetFields.put("X", Parser.parseDouble(data));
        result.packetFields.put("Y", Parser.parseDouble(data));
        result.packetFields.put("Z", Parser.parseDouble(data));
        result.packetFields.put("Yaw", Parser.parseFloat(data));
        result.packetFields.put("Pitch", Parser.parseFloat(data));
        result.packetFields.put("Flags", Parser.parseByte(data));
        result.packetFields.put("Teleport ID", Parser.parseVarInt(data));
        return result;
    }
}
