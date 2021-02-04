package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class NBTQueryResponseParser extends AbstractPacketParser implements PacketParser {

    public NBTQueryResponseParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x54", "NBTQueryResponseParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("NBT Query Response");
        return result;
    }
}
