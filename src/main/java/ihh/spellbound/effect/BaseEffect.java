package ihh.spellbound.effect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class BaseEffect extends Effect {
    public BaseEffect(EffectType typeIn) {
        super(typeIn, 0xffffff);
    }
}
