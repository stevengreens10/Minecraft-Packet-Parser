package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ServerDifficultyParser extends AbstractPacketParser implements PacketParser {

    public ServerDifficultyParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0D", "ServerDifficultyParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Server Difficulty");
        result.packetFields.put("Difficulty", Parser.parseUnsignedByte(data));
        result.packetFields.put("Difficulty Locked?", Parser.parseBoolean(data));
        return result;
    }
}
