package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Haste extends AbstractBeneficialPotionSpell {
    public Haste() {
        super(new EffectInstance(Effects.HASTE, 1200));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.HASTE;
    }
}
