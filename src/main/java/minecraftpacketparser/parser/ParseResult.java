package minecraftpacketparser.parser;

import java.util.LinkedHashMap;
import java.util.Map;

public class ParseResult {
    public State resultState;
    public String packetType;
    public Map<String, Object> packetFields;

    public ParseResult(String packetType) {
        this(packetType, null);
    }

    public ParseResult(String packetType, State resultState) {
        this.packetType = packetType;
        this.resultState = resultState;
        // LinkedHashMap iterates over elements in same order as insertion
        this.packetFields = new LinkedHashMap<>();
    }
}
