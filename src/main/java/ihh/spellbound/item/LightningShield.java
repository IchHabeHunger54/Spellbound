package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;

public final class LightningShield extends AbstractBeneficialPotionSpell {
    public LightningShield() {
        super(new EffectInstance(EffectInit.lightning_shield, 1200));
    }

    @Override
    protected Time getTime() {
        return Time.ONE;
    }
}
