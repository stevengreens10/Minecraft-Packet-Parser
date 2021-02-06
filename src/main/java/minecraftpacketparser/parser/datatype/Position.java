package minecraftpacketparser.parser.datatype;

public class Position {
    public long x;
    public long y;
    public long z;

    public Position(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", x, y, z);
    }
}
