package ihh.spellbound.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec config;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();
        SpellTimeConfig.init(b);
        config = b.build();
    }
}
