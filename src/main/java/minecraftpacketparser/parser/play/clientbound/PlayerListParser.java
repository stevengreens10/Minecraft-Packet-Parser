package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PlayerListParser extends AbstractPacketParser implements PacketParser {

    public PlayerListParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x54", "PlayerListParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
