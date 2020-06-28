package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PluginMessageServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PluginMessageServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0B", "PluginMessageServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        output.printf("\tIdentifier: %s\n", Parser.parseIdentifier(data));
        return null;
    }
}
