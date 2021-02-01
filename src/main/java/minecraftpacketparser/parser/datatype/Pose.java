package minecraftpacketparser.parser.datatype;

public enum Pose {
    STANDING, FALL_FLYING, SLEEPING, SWIMMING, SPIN_ATTACK, SNEAKING, DYING;


    @Override
    public String toString() {
        return this.name();
    }
}
