package ihh.spellbound.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public class PotionSpell extends Spell {
    private final EffectInstance effect;

    public PotionSpell(ForgeConfigSpec.IntValue timeConfig, Type type, EffectInstance instance) {
        super(timeConfig, type);
        effect = instance;
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        target.addPotionEffect(effect);
        return true;
    }
}
