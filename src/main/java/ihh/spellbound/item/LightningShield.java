package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class LightningShield extends AbstractBeneficialPotionSpell {
    public LightningShield() {
        super(new EffectInstance(EffectInit.lightning_shield, 1200));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.LIGHTNING_SHIELD;
    }
}
