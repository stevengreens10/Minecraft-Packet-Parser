package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BlockEntityDataParser extends AbstractPacketParser implements PacketParser {

    public BlockEntityDataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x09", "BlockEntityDataParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Block Entity Data");
        result.packetFields.put("Location", Parser.parsePosition(data));
        result.packetFields.put("Action", Parser.parseUnsignedByte(data));
//        byte[] bytes = new byte[1000];
//        data.read(bytes, 0, 1000);
//        result.packetFields.put("NBT Data", "0x" + Hex.encodeHexString(bytes));
        result.packetFields.put("NBT Data", Parser.parseNBT(data));
        return result;
    }
}
