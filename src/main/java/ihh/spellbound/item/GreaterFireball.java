package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.server.ServerWorld;

public final class GreaterFireball extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.FIRE_SHIELD.get())) {
            target.attackEntityFrom(DamageSource.MAGIC, 10);
            world.createExplosion(target, target.getPosX(), target.getPosY(), target.getPosZ(), 5, true, Explosion.Mode.DESTROY);
            return true;
        }
        return false;
    }

    @Override
    protected Time getTime() {
        return Time.THREE;
    }
}
