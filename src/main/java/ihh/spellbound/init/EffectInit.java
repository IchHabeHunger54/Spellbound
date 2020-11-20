package ihh.spellbound.init;

import ihh.spellbound.BaseEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;

public final class EffectInit implements IInit {
    public static final Effect archmagic = new BaseEffect(EffectType.BENEFICIAL);
    public static final Effect chaos = new BaseEffect(EffectType.HARMFUL);
    public static final Effect cold_shield = new BaseEffect(EffectType.BENEFICIAL);
    public static final Effect fire_shield = new BaseEffect(EffectType.BENEFICIAL);
    public static final Effect flight = new BaseEffect(EffectType.BENEFICIAL);
    public static final Effect lightning_shield = new BaseEffect(EffectType.BENEFICIAL);
    public static final Effect miscast_magic = new BaseEffect(EffectType.HARMFUL);
    public static final Effect spell_shield = new BaseEffect(EffectType.BENEFICIAL);
    public static final Effect surge_shield = new BaseEffect(EffectType.BENEFICIAL);
    public static final RegistryObject<Effect> ARCHMAGIC = EFFECTS.register("archmagic", () -> archmagic);
    public static final RegistryObject<Effect> CHAOS = EFFECTS.register("chaos", () -> chaos);
    public static final RegistryObject<Effect> COLD_SHIELD = EFFECTS.register("cold_shield", () -> cold_shield);
    public static final RegistryObject<Effect> FIRE_SHIELD = EFFECTS.register("fire_shield", () -> fire_shield);
    public static final RegistryObject<Effect> FLIGHT = EFFECTS.register("flight", () -> flight);
    public static final RegistryObject<Effect> LIGHTNING_SHIELD = EFFECTS.register("lightning_shield", () -> lightning_shield);
    public static final RegistryObject<Effect> MISCAST_MAGIC = EFFECTS.register("miscast_magic", () -> miscast_magic);
    public static final RegistryObject<Effect> SPELL_SHIELD = EFFECTS.register("spell_shield", () -> spell_shield);
    public static final RegistryObject<Effect> SURGE_SHIELD = EFFECTS.register("surge_shield", () -> surge_shield);

    public static void init() {
    }
}
