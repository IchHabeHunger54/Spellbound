package ihh.spellbound.init;

import ihh.spellbound.effect.BaseEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.RegistryObject;

public interface EffectInit extends IInit {
    MobEffect archmagic = new BaseEffect(MobEffectCategory.BENEFICIAL);
    MobEffect chaos = new BaseEffect(MobEffectCategory.HARMFUL);
    MobEffect cold_shield = new BaseEffect(MobEffectCategory.BENEFICIAL);
    MobEffect fire_shield = new BaseEffect(MobEffectCategory.BENEFICIAL);
    MobEffect flight = new BaseEffect(MobEffectCategory.BENEFICIAL);
    MobEffect lightning_shield = new BaseEffect(MobEffectCategory.BENEFICIAL);
    MobEffect miscast_magic = new BaseEffect(MobEffectCategory.HARMFUL);
    MobEffect spell_shield = new BaseEffect(MobEffectCategory.BENEFICIAL);
    MobEffect surge_shield = new BaseEffect(MobEffectCategory.BENEFICIAL);
    RegistryObject<MobEffect> ARCHMAGIC = EFFECTS.register("archmagic", () -> archmagic);
    RegistryObject<MobEffect> CHAOS = EFFECTS.register("chaos", () -> chaos);
    RegistryObject<MobEffect> COLD_SHIELD = EFFECTS.register("cold_shield", () -> cold_shield);
    RegistryObject<MobEffect> FIRE_SHIELD = EFFECTS.register("fire_shield", () -> fire_shield);
    RegistryObject<MobEffect> FLIGHT = EFFECTS.register("flight", () -> flight);
    RegistryObject<MobEffect> LIGHTNING_SHIELD = EFFECTS.register("lightning_shield", () -> lightning_shield);
    RegistryObject<MobEffect> MISCAST_MAGIC = EFFECTS.register("miscast_magic", () -> miscast_magic);
    RegistryObject<MobEffect> SPELL_SHIELD = EFFECTS.register("spell_shield", () -> spell_shield);
    RegistryObject<MobEffect> SURGE_SHIELD = EFFECTS.register("surge_shield", () -> surge_shield);

    static void init() {
    }
}
