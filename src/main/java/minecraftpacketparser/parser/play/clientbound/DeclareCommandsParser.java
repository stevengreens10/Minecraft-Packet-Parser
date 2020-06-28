package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class DeclareCommandsParser extends AbstractPacketParser implements PacketParser {

    public DeclareCommandsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x12", "DeclareCommandsParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
