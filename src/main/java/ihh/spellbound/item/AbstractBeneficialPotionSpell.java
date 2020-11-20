package ihh.spellbound.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.server.ServerWorld;

public abstract class AbstractBeneficialPotionSpell extends AbstractSelfSpell {
    private final EffectInstance effect;

    public AbstractBeneficialPotionSpell(EffectInstance instance) {
        effect = instance;
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        target.addPotionEffect(effect);
        return true;
    }
}
