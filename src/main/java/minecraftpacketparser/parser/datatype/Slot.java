package minecraftpacketparser.parser.datatype;

import com.flowpowered.nbt.EndTag;
import com.flowpowered.nbt.Tag;

public class Slot {
    public boolean present;
    public int itemID;
    public int itemCount;
    public Tag nbtData;

    @Override
    public String toString() {
        String val = "Slot: \n"
                + "\t  Present: " + present + "\n";
        if (present) {
            val += "\t  Item ID: " + itemID + "\n"
                    + "\t  Item Count: " + itemCount + "\n";
            if (nbtData instanceof EndTag) {
                val += "\t  NBT Data: N/A\n";
            } else {
                val += "\t  NBT Data: \n\t  " + nbtData.toString().replace("\n", "\n\t  ") + "\n";
            }
        }
        return val;
    }
}
