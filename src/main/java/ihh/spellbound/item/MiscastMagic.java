package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;

public final class MiscastMagic extends AbstractHarmfulPotionSpell {
    public MiscastMagic() {
        super(new EffectInstance(EffectInit.miscast_magic, 200));
    }

    @Override
    protected Time getTime() {
        return Time.THREE;
    }
}
