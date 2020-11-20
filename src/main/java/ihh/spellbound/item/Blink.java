package ihh.spellbound.item;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public final class Blink extends AbstractBeneficialPotionSpell {
    public Blink() {
        super(new EffectInstance(Effects.INVISIBILITY, 1200));
    }

    @Override
    protected Time getTime() {
        return Time.THREE;
    }
}
