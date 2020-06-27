package minecraftpacketparser.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class AbstractPacketParser implements PacketParser {

    public State state;
    public Direction direction;
    public String id;
    public String name;

    public AbstractPacketParser(State state, Direction direction, String id, String name) {
        this.state = state;
        this.direction = direction;
        this.id = id;
        this.name = name;
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
        output.println(String.format("\tHandled by %s. %s %s %s", name, state.name(), direction.name(), id));
    }
}
