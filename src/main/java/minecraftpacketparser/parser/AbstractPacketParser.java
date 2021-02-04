package minecraftpacketparser.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;

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
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        return null;
    }
}
