package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Blink extends AbstractBeneficialPotionSpell {
    public Blink() {
        super(new EffectInstance(Effects.INVISIBILITY, 1200));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.BLINK;
    }
}
