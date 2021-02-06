package minecraftpacketparser.parser.datatype;

import net.querz.nbt.io.NamedTag;
import net.querz.nbt.io.SNBTUtil;

import java.io.IOException;

public class Slot {
    public boolean present;
    public int itemID;
    public int itemCount;
    public NamedTag nbtData;

    @Override
    public String toString() {
        String val = "Slot: \n"
                + "\t  Present: " + present + "\n";
        if (present) {
            val += "\t  Item ID: " + itemID + "\n"
                    + "\t  Item Count: " + itemCount + "\n";
            if (nbtData == null || nbtData.getTag().getID() == 0) {
                val += "\t  NBT Data: N/A\n";
            } else {
                try {
                    val += "\t  NBT Data: \n\t\t" + SNBTUtil.toSNBT(nbtData.getTag()) + "\n";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return val;
    }
}
