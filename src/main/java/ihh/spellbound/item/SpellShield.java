package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;

public final class SpellShield extends AbstractBeneficialPotionSpell {
    public SpellShield() {
        super(new EffectInstance(EffectInit.spell_shield, 400));
    }

    @Override
    protected Time getDefaultTime() {
        return Time.ONE;
    }
}
