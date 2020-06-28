package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class BlockActionParser extends AbstractPacketParser implements PacketParser {

    public BlockActionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0B", "BlockActionParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
