package minecraftpacketparser.parser;

import minecraftpacketparser.parser.handshake.serverbound.StartHandshakeParser;
import minecraftpacketparser.parser.login.clientbound.*;
import minecraftpacketparser.parser.login.serverbound.EncryptionResponseParser;
import minecraftpacketparser.parser.login.serverbound.LoginPluginResponseParser;
import minecraftpacketparser.parser.login.serverbound.LoginStartParser;
import minecraftpacketparser.parser.play.clientbound.*;
import minecraftpacketparser.parser.play.serverbound.*;
import minecraftpacketparser.parser.status.clientbound.PongParser;
import minecraftpacketparser.parser.status.clientbound.StatusResponseParser;
import minecraftpacketparser.parser.status.serverbound.PingParser;
import minecraftpacketparser.parser.status.serverbound.StatusRequestParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    // state -> packet id -> direction -> parser
    private static Map<State, Map<String, Map<Direction, AbstractPacketParser>>> parsers = new HashMap<>();
    public static State state = State.PLAY;

    public static void initialize() {
        parsers.put(State.HANDSHAKE, new HashMap<String, Map<Direction, AbstractPacketParser>>());
        parsers.put(State.STATUS, new HashMap<String, Map<Direction, AbstractPacketParser>>());
        parsers.put(State.LOGIN, new HashMap<String, Map<Direction, AbstractPacketParser>>());
        parsers.put(State.PLAY, new HashMap<String, Map<Direction, AbstractPacketParser>>());

        addParser(State.HANDSHAKE, Direction.SERVERBOUND, "0x00", new StartHandshakeParser());

        addParser(State.STATUS, Direction.CLIENTBOUND, "0x00", new StatusResponseParser());
        addParser(State.STATUS, Direction.CLIENTBOUND, "0x01", new PongParser());
        addParser(State.STATUS, Direction.SERVERBOUND, "0x00", new StatusRequestParser());
        addParser(State.STATUS, Direction.SERVERBOUND, "0x01", new PingParser());

        addParser(State.LOGIN, Direction.CLIENTBOUND, "0x00", new LoginDisconnectParser());
        addParser(State.LOGIN, Direction.CLIENTBOUND, "0x01", new EncryptionRequestParser());
        addParser(State.LOGIN, Direction.CLIENTBOUND, "0x02", new LoginSucessParser());
        addParser(State.LOGIN, Direction.CLIENTBOUND, "0x03", new SetCompressionParser());
        addParser(State.LOGIN, Direction.CLIENTBOUND, "0x04", new LoginPluginRequestParser());
        addParser(State.LOGIN, Direction.SERVERBOUND, "0x00", new LoginStartParser());
        addParser(State.LOGIN, Direction.SERVERBOUND, "0x01", new EncryptionResponseParser());
        addParser(State.LOGIN, Direction.SERVERBOUND, "0x02", new LoginPluginResponseParser());

        addParser(State.PLAY, Direction.CLIENTBOUND, "0x00", new SpawnEntityParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x01", new SpawnExperienceOrbParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x02", new SpawnWeatherEntityParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x03", new SpawnLivingEntityParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x04", new SpawnPaintingParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x05", new SpawnPlayerParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x06", new EntityAnimationParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x07", new StatisticsParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x08", new AckPlayerDiggingParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x09", new BlockBreakAnimParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x0A", new BlockEntityDataParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x0B", new BlockActionParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x0C", new BlockChangeParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x0D", new BossBarParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x0E", new ServerDifficultyParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x0F", new ChatMessageClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x10", new MultiBlockChangeParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x11", new TabCompleteClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x12", new DeclareCommandsParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x13", new WindowConfirmationClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x14", new CloseWindowParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x15", new WindowItemsParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x16", new WindowPropertyParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x17", new SetSlotParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x18", new SetCooldownParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x19", new PluginMessageClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x1A", new NamedSoundEffectParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x1B", new PlayDisconnectParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x1C", new EntityStatusParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x1D", new ExplosionParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x1E", new UnloadChunkParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x1F", new ChangeGameStateParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x20", new OpenHorseWindowParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x21", new KeepAliveClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x22", new ChunkDataParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x23", new EffectParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x24", new ParticleParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x25", new UpdateLightParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x26", new JoinGameParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x27", new MapDataParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x28", new TradeListParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x29", new EntityPositionParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x2A", new EntityPositionAndRotation());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x2B", new EntityRotationParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x2C", new EntityMovementParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x2D", new VehicleMoveClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x2E", new OpenBookParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x2F", new OpenWindowParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x30", new OpenSignEditorParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x31", new CraftRecipeResponseParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x32", new PlayerAbilitiesClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x33", new CombatEventParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x34", new PlayerInfoParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x35", new FacePlayerParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x36", new PlayerPosAndLookClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x37", new UnlockRecipesParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x38", new DestroyEntitiesParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x39", new RemoveEntityEffect());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x3A", new ResourcePackSendParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x3B", new RespawnParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x3C", new EntityHeadLookParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x3D", new SelectAdvancementTabParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x3E", new WorldBorderParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x3F", new CameraParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x40", new HeldItemChangeClientBoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x41", new UpdateViewPositionParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x42", new UpdateViewDistanceParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x43", new DisplayScoreboardParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x44", new EntityMetadataParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x45", new AttachEntityParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x46", new EntityVelocityParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x47", new EntityEquipmentParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x48", new SetExperienceParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x49", new UpdateHealthParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x4A", new ScoreboardObjectiveParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x4B", new SetPassengersParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x4C", new TeamsParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x4D", new UpdateScoreParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x4E", new SpawnPositionParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x4F", new TimeUpdateParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x50", new TitleParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x51", new EntitySoundEffectParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x52", new SoundEffectParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x53", new StopSoundParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x54", new PlayerListParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x55", new NBTQueryResponseParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x56", new CollectItemParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x57", new EntityTeleportParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x58", new AdvancementsParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x59", new EntityPropertiesParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x5A", new EntityEffectParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x5B", new DeclareRecipesParser());
        addParser(State.PLAY, Direction.CLIENTBOUND, "0x5C", new TagsParser());

        addParser(State.PLAY, Direction.SERVERBOUND, "0x00", new TeleportConfirmParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x01", new QueryBlockNBTParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x02", new SetDifficultyParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x03", new ChatMessageServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x04", new ClientStatusParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x05", new ClientSettingsParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x06", new TabCompleteServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x07", new WindowConfirmationServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x08", new ClickWindowButtonParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x09", new ClickWindowParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x0A", new CloseWindowServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x0B", new PluginMessageServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x0C", new EditBookParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x0D", new EntityNBTRequest());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x0E", new InteractEntityParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x0F", new KeepAliveServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x10", new LockDifficultyParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x11", new PlayerPositionParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x12", new PlayerPosAndLookServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x13", new PlayerRotationParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x14", new PlayerMovementParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x15", new VehicleMoveServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x16", new SteerBoatParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x17", new PickItemParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x18", new CraftRecipeRequestParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x19", new PlayerAbilitiesServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x1A", new PlayerDiggingParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x1B", new EntityActionParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x1C", new SteerVehicleParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x1D", new RecipeBookDataParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x1E", new NameItemParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x1F", new ResourcePackStatusParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x20", new AdvancementTabParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x21", new SelectTradeParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x22", new SetBeaconEffectParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x23", new HeldItemChangeServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x24", new UpdateCommandBlockParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x25", new UpdateCommandBlockMinecartParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x26", new CreativeInventoryActionParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x27", new UpdateJigsawBlockParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x28", new UpdateStructureBlockParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x29", new UpdateSignParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x2A", new AnimationServerBoundParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x2B", new SpectateParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x2C", new PlayerBlockPlaceParser());
        addParser(State.PLAY, Direction.SERVERBOUND, "0x2D", new UseItemParser());
    }

    private static void addParser(State state, Direction dir, String id, AbstractPacketParser parser) {
        if(!parsers.get(state).containsKey(id)) {
            parsers.get(state).put(id, new HashMap<Direction, AbstractPacketParser>());
        }
        parsers.get(state).get(id).put(dir, parser);
    }

    public static boolean handlePacket(InputStream packetData, Direction direction, PrintStream output) {
        try {
            int length = Parser.parseVarInt(packetData);
            String packetID = Parser.intToHexStr(Parser.parseVarInt(packetData));

            if(length == 0) {
                return true;
            }

            output.println("Packet ID: " + packetID + " | Length: " + length);

            AbstractPacketParser parser;
            try {
                parser = parsers.get(state).get(packetID).get(direction);
            } catch (NullPointerException ne) {
                output.println("\tNot handled!");
                throw new RuntimeException(String.format("No parser for packet ID %s in state %s with %s direction", packetID, state.name(), direction.name()));
            }
            parser.parse(packetData, output);
        } catch (Exception e) {
            return true;
        }

        return false;
    }

    public static String intToHexStr(int val) {
        return String.format("0x%02X", val);
    }

    public static int parseVarInt(InputStream data) throws IOException {
        int numRead = 0;
        int result = 0;
        byte read;
        do {
            int readInt = data.read();
            if (readInt == -1) {
                throw new RuntimeException("Not enough data");
            }
            read = (byte) readInt;
            int value = (read & 0b01111111);
            result |= (value << (7 * numRead));

            numRead++;
            if (numRead > 5) {
                throw new RuntimeException("VarInt is too big");
            }
        } while ((read & 0b10000000) != 0);

        return result;
    }

}