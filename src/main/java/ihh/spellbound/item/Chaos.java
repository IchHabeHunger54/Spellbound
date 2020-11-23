package ihh.spellbound.item;

import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Chaos extends AbstractHarmfulPotionSpell {
    public Chaos() {
        super(new EffectInstance(EffectInit.chaos, SpellConfig.CHAOS_DURATION.get()));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.CHAOS;
    }
}
