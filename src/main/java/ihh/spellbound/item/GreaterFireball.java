package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.server.ServerWorld;

public final class GreaterFireball extends Spell {
    public GreaterFireball() {
        super(Config.GREATER_FIREBALL_USE_DURATION, Type.TARGET);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.FIRE_SHIELD.get())) {
            target.attackEntityFrom(DamageSource.ON_FIRE, Config.GREATER_FIREBALL_DAMAGE.get());
            world.createExplosion(target, target.getPosX(), target.getPosY(), target.getPosZ(), 5, true, Explosion.Mode.DESTROY);
            return true;
        }
        return false;
    }
}
