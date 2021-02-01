package minecraftpacketparser.parser.datatype;

public class VillagerData {
    public int type;
    public int profession;
    public int level;

    public VillagerData(int type, int profession, int level) {
        this.type = type;
        this.profession = profession;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Type: " + getTypeString() + "\n"
                + "Profession: " + getProfessionString() + "\n"
                + "Level: " + level;
    }

    private String getTypeString() {
        String[] types = new String[]{"desert", "jungle", "plains", "savanna", "snow", "swamp", "taiga"};
        return "minecraft:" + types[type];
    }

    private String getProfessionString() {
        String[] professions = new String[]{"none", "armorer", "butcher", "cartographer", "cleric",
                "farmer", "fisherman", "fletcher", "leatherworker", "librarian", "mason",
                "nitwin", "shepherd", "toolsmith", "weaponsmith"};
        return "minecraft:" + professions[profession];
    }
}
