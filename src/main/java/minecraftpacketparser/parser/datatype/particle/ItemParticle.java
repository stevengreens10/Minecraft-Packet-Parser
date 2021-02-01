package minecraftpacketparser.parser.datatype.particle;

import minecraftpacketparser.parser.datatype.Slot;

public class ItemParticle extends Particle {
    public Slot slot;

    public ItemParticle(int id, Slot slot) {
        super(id);
        this.slot = slot;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Slot: " + slot;
    }
}
