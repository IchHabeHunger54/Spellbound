package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;

public final class ColdShield extends AbstractBeneficialPotionSpell {
    public ColdShield() {
        super(new EffectInstance(EffectInit.cold_shield, 1200));
    }

    @Override
    protected Time getDefaultTime() {
        return Time.ONE;
    }
}
