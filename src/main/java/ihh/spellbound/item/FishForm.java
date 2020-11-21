package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ForgeConfigSpec;

public final class FishForm extends AbstractBeneficialPotionSpell {
    public FishForm() {
        super(new EffectInstance(Effects.WATER_BREATHING, 1200));
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.FISH_FORM;
    }
}
