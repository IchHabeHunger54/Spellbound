package ihh.spellbound.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec config;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        config = builder.build();
    }
}
