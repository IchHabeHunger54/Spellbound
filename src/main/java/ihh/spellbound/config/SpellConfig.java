package ihh.spellbound.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SpellConfig {
    public static void init(ForgeConfigSpec.Builder b) {
        b.push("spell");
        b.pop();
    }
}
