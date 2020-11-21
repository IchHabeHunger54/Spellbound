package ihh.spellbound.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
    public static ForgeConfigSpec config;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();
        SpellTimeConfig.init(b);
        SurgeConfig.init(b);
        config = b.build();
    }

    @SubscribeEvent
    public static void reload(ModConfig.ModConfigEvent e) {
        if(e.getConfig().getType() == ModConfig.Type.SERVER) SurgeConfig.reload();
    }
}
