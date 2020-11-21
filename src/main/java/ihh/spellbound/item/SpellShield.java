package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class SpellShield extends AbstractBeneficialPotionSpell {
    public SpellShield() {
        super(new EffectInstance(EffectInit.spell_shield, 400));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.SPELL_SHIELD;
    }
}
