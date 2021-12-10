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

public class Fireball extends SpellProjectile {
    public Fireball(EntityType<? extends Fireball> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        level.explode(this, getX(), getY(), getZ(), 3, true, Explosion.BlockInteraction.BREAK);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).hasEffect(EffectInit.fire_shield))
            result.getEntity().hurt(DamageSource.ON_FIRE, Config.FIREBALL_DAMAGE.get());
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.FIREBALL.get());
    }
}
