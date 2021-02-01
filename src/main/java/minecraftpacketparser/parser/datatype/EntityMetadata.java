package minecraftpacketparser.parser.datatype;

public class EntityMetadata {
    public int index;
    public EntityMetadata.Type type;
    public Object value;
    public Boolean optionalPresent;

    @Override
    public String toString() {
        if(index == 0xFF || type == null) {
            return "";
        }

        String val = "Type: " + type.name() + "\n";
        if (type.isOptional()) {
            val += "Present: " + optionalPresent;
            if(!optionalPresent) {
                return val;
            }
        }

        String[] lines = value.toString().split("\n");
        String valString;
        if(lines.length == 1) {
            valString = "\tValue: " + lines[0] + "\n";
        } else {
            valString = "\tValue:\n";
            for (String line : lines) {
                valString += "\t\t" + line + "\n";
            }
        }

        return val + valString;
    }

    public enum Type {
        BYTE, VARINT, FLOAT, STRING, CHAT, OPTCHAT, SLOT, BOOLEAN, ROTATION, POSITION, OPTPOSITION,
        DIRECTION, OPTUUID, OPTBLOCKID, NBT, PARTICLE, VILLAGERDATA, OPTVARINT, POSE;

        public boolean isOptional() {
            return this == OPTCHAT || this == OPTPOSITION || this == OPTUUID
                    || this == OPTBLOCKID || this == OPTVARINT;
        }
    }
}
