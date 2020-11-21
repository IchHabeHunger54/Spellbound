package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class MiscastMagic extends AbstractHarmfulPotionSpell {
    public MiscastMagic() {
        super(new EffectInstance(EffectInit.miscast_magic, 200));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.MISCAST_MAGIC;
    }
}
