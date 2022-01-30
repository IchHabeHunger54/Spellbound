package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class GreaterFireball extends SpellProjectile {
    public GreaterFireball(EntityType<? extends GreaterFireball> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        level.explode(this, getX(), getY(), getZ(), 4, true, Explosion.BlockInteraction.BREAK);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.SPELL_SHIELD.get()) && !((LivingEntity) result.getEntity()).hasEffect(EffectInit.FIRE_SHIELD.get())) {
            result.getEntity().hurt(DamageSource.ON_FIRE, Config.GREATER_FIREBALL_DAMAGE.get());
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.GREATER_FIREBALL.get());
    }
}
