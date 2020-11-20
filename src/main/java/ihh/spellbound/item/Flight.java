package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;

public final class Flight extends AbstractBeneficialPotionSpell {
    public Flight() {
        super(new EffectInstance(EffectInit.flight, 1200));
    }

    @Override
    protected Time getDefaultTime() {
        return Time.FOUR;
    }
}
