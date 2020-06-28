package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class UpdateViewPositionParser extends AbstractPacketParser implements PacketParser {

    public UpdateViewPositionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x41", "UpdateViewPositionParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);

        int chunkX = Parser.parseVarInt(data);
        int chunkY = Parser.parseVarInt(data);

        ParseResult result = new ParseResult(this.name, State.PLAY);
        result.packetFields.put("Chunk X", chunkX);
        result.packetFields.put("Chunk Y", chunkY);

    	return result;
	}
}
