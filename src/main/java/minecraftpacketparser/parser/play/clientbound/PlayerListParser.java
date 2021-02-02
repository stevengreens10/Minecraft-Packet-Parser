package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerListParser extends AbstractPacketParser implements PacketParser {

    public PlayerListParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x54", "PlayerListParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player List");
        return result;
    }
}
