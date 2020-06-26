# Minecraft-Packet-Parser
MPP? It's easy as, 123. As simple as, do re mi.

Thoughts..

```java
public class Parser {
  
  // state -> packet id -> direction -> parser
  private static Map<String, Map<String, Map<Direction, PacketParser>>> parsers = new HashMap<>();
  private static String state = "play";
  
  public static void initialize() {
    parsers.put("handshake", new HashMap<>());
    parsers.put("status", new HashMap<>());
    parsers.put("login", new HashMap<>());
    parsers.put("play", new HashMap<>());
    
    parsers.get("play").put("0x41", new HashMap<>());
    parsers.get("play").get("0x41").put(Direction.clientbound, new UpdateViewPositionParser());
  }
  
  public static void handlePacket(InputStream packetData, Direction direction, OutputStream output) {
    int length = Parser.parseVarInt(packetData);
    int packetID = Parser.parseVarInt(packetData);
    
    PacketParser parser = parsers.get(state).get(Parser.intToHexStr(packetID)).get(direction);
    parser.parse(packetData, output);
  }
  
  protected static int parseVarInt(InputStream data) {
    int numRead = 0;
    int result = 0;
    byte read;
    do {
        int readInt = data.read();
        if readInt == -1 {
          throw new RuntimeException();
        }
        read = (byte) readInt;
        int value = (read & 0b01111111);
        result |= (value << (7 * numRead));

        numRead++;
        if (numRead > 5) {
            throw new RuntimeException("VarInt is too big");
        }
    } while ((read & 0b10000000) != 0);

    return result;
  }

}
```
