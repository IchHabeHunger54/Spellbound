package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class SurgeShield extends AbstractBeneficialPotionSpell {
    public SurgeShield() {
        super(new EffectInstance(EffectInit.surge_shield, 1200));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.SURGE_SHIELD;
    }
}
