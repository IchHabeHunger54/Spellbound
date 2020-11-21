package ihh.spellbound.config;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

public class SurgeConfig {
    public static ForgeConfigSpec.IntValue CHANCE;
    public static ForgeConfigSpec.IntValue CHAOS_CHANCE;
    public static ForgeConfigSpec.IntValue FIRE;
    public static ForgeConfigSpec.BooleanValue POTION;
    private static ForgeConfigSpec.ConfigValue<List<? extends String>> POTIONS;
    private static final ArrayList<String> DEFAULT_POTIONS = Lists.newArrayList("minecraft:weakness;200;0;true;true", "minecraft:poison;200;0;true;true");
    public static ArrayList<EffectInstance> EFFECTS;

    public static void init(ForgeConfigSpec.Builder b) {
        b.push("surge");
        CHANCE = b.comment("The chance (1 in X) for surges to occur. Set to 0 to disable surges entirely.").defineInRange("chance", 200, 0, 1000000);
        CHAOS_CHANCE = b.comment("The chance (1 in X) for surges to occur when the Chaos potion effect is active. Set to 0 to instead disable surges when Chaos is active").defineInRange("chaos_chance", 2, 0, 1000000);
        FIRE = b.comment("How long the fire surge sets you on fire. Set this to 0 to disable.").defineInRange("fire", 10, 0, 1000);
        POTION = b.comment("Whether the potion surge is enabled or not.").define("potion", true);
        POTIONS = b.comment("List of potion surges. Format is \"registryName;duration;amplifier;showParticles;showIcon\"").defineList("potions", DEFAULT_POTIONS, o -> (o instanceof String) && ((String) o).split(";").length >= 2 && ((String) o).split(";").length <= 5);
        EFFECTS = new ArrayList<>();
    }

    public static void reload() {
        EFFECTS.clear();
        POTIONS.get().stream().map(s -> s.split(";")).filter(s -> s.length >= 2 && s.length <= 5).forEach(s -> {
            try {
                ResourceLocation rl = ResourceLocation.tryCreate(s[0]);
                if (rl == null) return;
                Effect e = ForgeRegistries.POTIONS.getValue(rl);
                if (e == null) return;
                int duration = Integer.parseInt(s[1]);
                int amplifier = Integer.parseInt(s[2]);
                int particles = Integer.parseInt(s[3]);
                int icon = Integer.parseInt(s[4]);
                EFFECTS.add(new EffectInstance(e, duration <= 1 ? 1 : Math.min(duration, 1000000), amplifier <= 0 ? 0 : Math.min(amplifier, 127), particles > 0, icon > 0));
            } catch (Throwable ignored) {
            }
        });
    }
}
