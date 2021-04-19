package ihh.spellbound.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class HarmfulPotionSpell extends TargetSpell {
    private final EffectInstance effect;

    public HarmfulPotionSpell(ForgeConfigSpec.IntValue config, EffectInstance instance) {
        super(config);
        effect = instance;
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        target.addPotionEffect(effect);
        return true;
    }
}
