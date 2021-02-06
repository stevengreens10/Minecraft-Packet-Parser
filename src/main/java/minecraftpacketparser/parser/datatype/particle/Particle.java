package minecraftpacketparser.parser.datatype.particle;

public class Particle {
    public int id;

    public Particle(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + getNameFromId();
    }

    private String getNameFromId() {
        String[] names = new String[]{"ambient_entity_effect", "angry_villager", "barrier", "block", "bubble",
                "cloud", "crit", "damage_indicator", "dragon_breath", "dripping_lava", "falling_lava",
                "landing_lava", "dripping_water", "falling_water", "dust", "effect", "elder_guardian",
                "enchanted_hit", "enchant", "end_rod", "entity_effect", "explosion_emitter", "explosion",
                "falling_dust", "firework", "fishing", "flame", "flash", "happy_villager", "composter", "heart",
                "instant_effect", "item", "item_slime", "item_snowball", "large_smoke", "lava", "mycelium",
                "note", "poof", "portal", "rain", "smoke", "sneeze", "spit", "squid_ink", "sweep_attack",
                "totem_of_undying", "underwater", "splash", "witch", "bubble_pop", "current_down",
                "bubble_column_up", "nautilus", "dolphin", "campfire_cosy_smoke", "campfire_signal_smoke",
                "dripping_honey", "falling_honey", "landing_honey", "falling_nectar"};
        return names[id];
    }
}
