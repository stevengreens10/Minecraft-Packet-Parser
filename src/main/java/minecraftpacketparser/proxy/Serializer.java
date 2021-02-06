package minecraftpacketparser.proxy;

import minecraftpacketparser.parser.datatype.*;
import minecraftpacketparser.parser.datatype.particle.BlockParticle;
import minecraftpacketparser.parser.datatype.particle.DustParticle;
import minecraftpacketparser.parser.datatype.particle.ItemParticle;
import minecraftpacketparser.parser.datatype.particle.Particle;
import net.querz.nbt.io.NBTSerializer;
import net.querz.nbt.io.NamedTag;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Serializer {

    public static void writeBoolean(boolean value, OutputStream out) throws IOException {
        byte val = 0x00;
        if(value) {
            val = 0x01;
        }
        out.write(val);
    }

    public static void writeByte(byte value, OutputStream out) throws IOException {
        out.write(value);
    }

    public static void writeUnsignedByte(int value, OutputStream out) throws IOException {
        out.write((byte) value);
    }

    public static void writeShort(short value, OutputStream out) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
        buffer.putShort(value);
        out.write(buffer.array());
    }

    public static void writeUnsignedShort(int value, OutputStream out) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
        buffer.putShort((short) value);
        out.write(buffer.array());
    }

    public static void writeInt(int value, OutputStream out) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.putInt(value);
        out.write(buffer.array());
    }

    public static void writeLong(long value, OutputStream out) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(value);
        out.write(buffer.array());
    }

    public static void writeFloat(float value, OutputStream out) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(Float.BYTES);
        buffer.putFloat(value);
        out.write(buffer.array());
    }

    public static void writeDouble(double value, OutputStream out) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(Double.BYTES);
        buffer.putDouble(value);
        out.write(buffer.array());
    }

    public static void writeString(String str, OutputStream out) throws IOException {
        int len = str.length();
        writeVarInt(len, out);
        byte[] strBytes = str.getBytes(StandardCharsets.UTF_8);
        out.write(strBytes);
    }

    public static void writeChat(String chat, OutputStream out) throws IOException {
        writeString(chat, out);
    }

    public static void writeIdentifier(String identifier, OutputStream out) throws IOException {
        writeString(identifier, out);
    }

    public static void writeVarInt(int value, OutputStream out) throws IOException {
        do {
            byte temp = (byte)(value & 0b01111111);
            // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            out.write(temp);
        } while (value != 0);
    }

    public static void writeVarLong(long value, OutputStream out) throws IOException {
        do {
            byte temp = (byte)(value & 0b01111111);
            // Note: >>> means that the sign bit is shifted with the rest of the number rather than being left alone
            value >>>= 7;
            if (value != 0) {
                temp |= 0b10000000;
            }
            out.write(temp);
        } while (value != 0);
    }

    public static void writeEntityMetadata(EntityMetadata[] metadata, OutputStream out) throws IOException {
        for(EntityMetadata meta : metadata) {
            writeUnsignedByte(meta.index, out);
            if(meta.index != 0xFF) {
                writeVarInt(meta.type.ordinal(), out);

                switch(meta.type) {
                    case BYTE:
                        writeByte((Byte) meta.value, out);
                        break;
                    case VARINT:
                    case OPTVARINT:
                    case OPTBLOCKID:
                        writeVarInt((Integer) meta.value, out);
                        break;
                    case FLOAT:
                        writeFloat((Float) meta.value, out);
                        break;
                    case STRING:
                        writeString((String) meta.value, out);
                        break;
                    case CHAT:
                        writeChat((String) meta.value, out);
                        break;
                    case OPTCHAT:
                        writeBoolean(meta.optionalPresent, out);
                        if(meta.optionalPresent)
                            writeChat((String) meta.value, out);
                        break;
                    case SLOT:
                        writeSlot((Slot) meta.value, out);
                        break;
                    case BOOLEAN:
                        writeBoolean((Boolean) meta.value, out);
                        break;
                    case ROTATION:
                        Rotation rot = (Rotation) meta.value;
                        writeFloat(rot.rotX, out);
                        writeFloat(rot.rotY, out);
                        writeFloat(rot.rotZ, out);
                        break;
                    case POSITION:
                        writePosition((Position) meta.value, out);
                        break;
                    case OPTPOSITION:
                        writeBoolean(meta.optionalPresent, out);
                        if(meta.optionalPresent)
                            writePosition((Position) meta.value, out);
                        break;
                    case DIRECTION:
                        writeVarInt(((DirectionDataType) meta.value).ordinal(), out);
                        break;
                    case OPTUUID:
                        writeBoolean(meta.optionalPresent, out);
                        if(meta.optionalPresent)
                            writeUUID((UUID) meta.value, out);
                        break;
                    case NBT:
                        writeNBT((NamedTag) meta.value, out);
                        break;
                    case PARTICLE:
                        Particle particle = (Particle) meta.value;
                        writeVarInt(particle.id, out);

                        if(particle.id == 3 || particle.id == 23) {
                            writeVarInt(((BlockParticle) particle).blockState, out);
                        } else if(particle.id == 14) {
                            writeFloat(((DustParticle) particle).red, out);
                            writeFloat(((DustParticle) particle).blue, out);
                            writeFloat(((DustParticle) particle).green, out);
                            writeFloat(((DustParticle) particle).scale, out);
                        } else if(particle.id == 32) {
                            writeSlot(((ItemParticle) particle).slot, out);
                        }

                        break;
                    case VILLAGERDATA:
                        VillagerData vd = (VillagerData) meta.value;
                        writeVarInt(vd.type, out);
                        writeVarInt(vd.profession, out);
                        writeVarInt(vd.level, out);
                        break;
                    case POSE:
                        writeVarInt(((Pose) meta.value).ordinal(), out);
                        break;
                }
            }
        }
    }

    public static void writeSlot(Slot slot, OutputStream out) throws IOException {
        writeBoolean(slot.present, out);

        if(slot.present) {
            writeVarInt(slot.itemID, out);
            writeByte((byte) slot.itemCount, out);
            writeNBT(slot.nbtData, out);
        }

    }

    public static void writeNBT(NamedTag nbt, OutputStream out) throws IOException{
        if(nbt == null) {
            writeByte((byte) 0, out);
            return;
        }

        out.write(new NBTSerializer(false).toBytes(nbt));
    }

    public static void writePosition(Position pos, OutputStream out) throws IOException {
        long posVal = ((pos.x & 0x3FFFFFF) << 38) | ((pos.z & 0x3FFFFFF) << 12) | (pos.y & 0xFFF);
        writeLong(posVal, out);
    }

    public static void writeAngle(byte angle, OutputStream out) throws IOException {
        writeByte(angle, out);
    }

    public static void writeUUID(UUID uuid, OutputStream out) throws IOException {
        long msLong = uuid.getMostSignificantBits();
        long lsLong = uuid.getLeastSignificantBits();

        writeLong(msLong, out);
        writeLong(lsLong, out);
    }

}
