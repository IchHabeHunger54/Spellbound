package ihh.spellbound.item;

import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class SurgeShield extends AbstractBeneficialPotionSpell {
    public SurgeShield() {
        super(new EffectInstance(EffectInit.surge_shield, SpellConfig.SURGE_SHIELD_DURATION.get()));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.SURGE_SHIELD;
    }
}
