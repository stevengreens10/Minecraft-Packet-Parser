package minecraftpacketparser.parser.datatype;

public enum DirectionDataType {
    DOWN, UP, NORTH, SOUTH, WEST, EAST;

    @Override
    public String toString() {
        return this.name();
    }
}
