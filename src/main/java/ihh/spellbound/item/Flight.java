package ihh.spellbound.item;

import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Flight extends AbstractBeneficialPotionSpell {
    public Flight() {
        super(new EffectInstance(EffectInit.flight, SpellConfig.FLIGHT_DURATION.get()));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.FLIGHT;
    }
}
