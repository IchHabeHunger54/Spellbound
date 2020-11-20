package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;

public final class Chaos extends AbstractHarmfulPotionSpell {
    public Chaos() {
        super(new EffectInstance(EffectInit.chaos, 200));
    }

    @Override
    protected Time getDefaultTime() {
        return Time.THREE;
    }
}
