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
    public void parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        output.println("\tChunk X: " + Parser.parseVarInt(data));
        output.println("\tChunk Y: " + Parser.parseVarInt(data));
    }
}
