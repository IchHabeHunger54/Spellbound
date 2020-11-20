package ihh.spellbound.item;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public final class Haste extends AbstractBeneficialPotionSpell {
    public Haste() {
        super(new EffectInstance(Effects.HASTE, 1200));
    }

    @Override
    protected Time getDefaultTime() {
        return Time.TWO;
    }
}
