package minecraftpacketparser.parser.datatype.particle;

public class DustParticle extends Particle {
    public float red, blue, green, scale;

    public DustParticle(int id, float red, float blue, float green, float scale) {
        super(id);
        this.red = red;
        this.blue = blue;
        this.green = green;
        this.scale = scale;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Red value: " + red + "\n"
                + "Blue value: " + blue + "\n"
                + "Green value: " + green + "\n"
                + "Scale value: " + scale + "\n";
    }
}
