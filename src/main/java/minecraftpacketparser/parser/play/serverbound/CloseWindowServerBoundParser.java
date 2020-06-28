package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class CloseWindowServerBoundParser extends AbstractPacketParser implements PacketParser {

    public CloseWindowServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0A", "CloseWindowServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
