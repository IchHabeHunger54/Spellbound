package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;

public final class Archmagic extends AbstractBeneficialPotionSpell {
    public Archmagic() {
        super(new EffectInstance(EffectInit.archmagic, 400));
    }

    @Override
    protected Time getDefaultTime() {
        return Time.THREE;
    }
}
