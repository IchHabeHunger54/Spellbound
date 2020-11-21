package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class FireShield extends AbstractBeneficialPotionSpell {
    public FireShield() {
        super(new EffectInstance(EffectInit.fire_shield, 1200));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.FIRE_SHIELD;
    }
}
