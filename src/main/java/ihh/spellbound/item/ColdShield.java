package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ColdShield extends AbstractBeneficialPotionSpell {
    public ColdShield() {
        super(new EffectInstance(EffectInit.cold_shield, 1200));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.COLD_SHIELD;
    }
}
