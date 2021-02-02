package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class AnimationServerBoundParser extends AbstractPacketParser implements PacketParser {

    public AnimationServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2C", "AnimationServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Animation Server Bound");
        return result;
    }
}
