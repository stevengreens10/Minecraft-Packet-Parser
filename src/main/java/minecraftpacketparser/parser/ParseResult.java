package minecraftpacketparser.parser;

import java.util.LinkedHashMap;
import java.util.Map;

public class ParseResult {
    public State resultState;
    public String parserName;
    public Map<String, Object> packetFields;

    public ParseResult(String parserName, State resultState) {
        this.parserName = parserName;
        this.resultState = resultState;
        // LinkedHashMap iterates over elements in same order as insertion
        this.packetFields = new LinkedHashMap<>();
    }
}
