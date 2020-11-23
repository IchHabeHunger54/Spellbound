package ihh.spellbound.item;

import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class LightningShield extends AbstractBeneficialPotionSpell {
    public LightningShield() {
        super(new EffectInstance(EffectInit.lightning_shield, SpellConfig.LIGHTNING_SHIELD_DURATION.get()));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.LIGHTNING_SHIELD;
    }
}
