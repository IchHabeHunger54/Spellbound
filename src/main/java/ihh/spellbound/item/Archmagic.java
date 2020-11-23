package ihh.spellbound.item;

import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Archmagic extends AbstractBeneficialPotionSpell {
    public Archmagic() {
        super(new EffectInstance(EffectInit.archmagic, SpellConfig.ARCHMAGIC_DURATION.get()));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.ARCHMAGIC;
    }
}
