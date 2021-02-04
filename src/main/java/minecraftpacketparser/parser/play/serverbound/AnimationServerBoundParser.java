package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AnimationServerBoundParser extends AbstractPacketParser implements PacketParser {

    public AnimationServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2C", "AnimationServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Animation Server Bound");
        return result;
    }
}
