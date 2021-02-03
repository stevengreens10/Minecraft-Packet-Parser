package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class UpdateLightParser extends AbstractPacketParser implements PacketParser {

    public UpdateLightParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x23", "UpdateLightParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Light");

        result.packetFields.put("Chunk X", Parser.parseVarInt(data));
        result.packetFields.put("Chunk Z", Parser.parseVarInt(data));
        result.packetFields.put("Trust Edges?", Parser.parseBoolean(data));
        result.packetFields.put("Sky Light Mask", Parser.parseVarInt(data));
        result.packetFields.put("Block Light Mask", Parser.parseVarInt(data));
        result.packetFields.put("Empty Sky Light Mask", Parser.parseVarInt(data));
        result.packetFields.put("Empty Block Light Mask", Parser.parseVarInt(data));

        int lenSkyLight = Parser.parseVarInt(data);
        int[] skyLight = new int[lenSkyLight];
        for(int i = 0; i < lenSkyLight; i++) {
            skyLight[i] = Parser.parseByte(data);
        }

        result.packetFields.put("Sky Light", Arrays.toString(skyLight));

        int lenBlockLight = Parser.parseVarInt(data);
        int[] blockLight = new int[lenBlockLight];
        for(int i = 0; i < lenBlockLight; i++) {
            blockLight[i] = Parser.parseByte(data);
        }

        result.packetFields.put("Block Light", Arrays.toString(blockLight));

        return result;
    }
}
