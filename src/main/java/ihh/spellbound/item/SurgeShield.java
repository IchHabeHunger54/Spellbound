package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;

public final class SurgeShield extends AbstractBeneficialPotionSpell {
    public SurgeShield() {
        super(new EffectInstance(EffectInit.surge_shield, 1200));
    }

    @Override
    protected Time getTime() {
        return Time.ONE;
    }
}
