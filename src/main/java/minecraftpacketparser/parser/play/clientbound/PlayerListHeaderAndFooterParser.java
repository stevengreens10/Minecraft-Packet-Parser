package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PlayerListHeaderAndFooterParser extends AbstractPacketParser implements PacketParser {

    public PlayerListHeaderAndFooterParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x53", "PlayerListHeaderAndFooterParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player List Header And Footer");
        return result;
    }
}
