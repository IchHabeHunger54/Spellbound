package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class Push extends SpellProjectile {
    public Push(EntityType<? extends Push> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        for (LivingEntity e : Util.getEntitiesInRange(level, this, Config.PUSH_RANGE.get())) {
            e.hurt(DamageSource.MAGIC, Config.PUSH_DAMAGE.get());
            e.knockback(Config.PUSH_STRENGTH.get(), getOwner().getX() - e.getX(), getOwner().getZ() - e.getZ());
        }
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.PUSH.get());
    }
}
