package ihh.spellbound.item;

import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Blink extends AbstractBeneficialPotionSpell {
    public Blink() {
        super(new EffectInstance(Effects.INVISIBILITY, SpellConfig.BLINK_DURATION.get()));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.BLINK;
    }
}
