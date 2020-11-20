package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class Disintegrate extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        target.setFire(10);
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()))
            target.attackEntityFrom(DamageSource.MAGIC, 100);
        return true;
    }

    @Override
    protected Time getDefaultTime() {
        return Time.FIVE;
    }
}
