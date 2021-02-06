package minecraftpacketparser.parser.datatype;

public class Rotation {
    public float rotX, rotY, rotZ;

    public Rotation(float rotX, float rotY, float rotZ) {
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
    }

    @Override
    public String toString() {
        return "(" + rotX + ", " + rotY + ", " + rotZ + ")";
    }
}
