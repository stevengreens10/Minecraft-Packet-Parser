package minecraftpacketparser.parser.datatype.particle;

public class BlockParticle extends Particle {
    public int blockState;

    public BlockParticle(int id, int blockState) {
        super(id);
        this.blockState = blockState;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Block State ID: " + blockState;
    }
}
