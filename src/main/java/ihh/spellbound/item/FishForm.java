package ihh.spellbound.item;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public final class FishForm extends AbstractBeneficialPotionSpell {
    public FishForm() {
        super(new EffectInstance(Effects.WATER_BREATHING, 1200));
    }

    @Override
    protected Time getTime() {
        return Time.THREE;
    }
}
