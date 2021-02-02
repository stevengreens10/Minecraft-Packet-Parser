package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerListHeaderAndFooterParser extends AbstractPacketParser implements PacketParser {

    public PlayerListHeaderAndFooterParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x53", "PlayerListHeaderAndFooterParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player List Header And Footer");
        return result;
    }
}
