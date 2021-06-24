package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class Push extends SpellProjectile {
    public Push(EntityType<? extends Push> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        for (LivingEntity e : Util.getEntitiesInRange(world, this, Config.PUSH_RANGE.get())) {
            e.attackEntityFrom(DamageSource.MAGIC, Config.PUSH_DAMAGE.get());
            e.applyKnockback(Config.PUSH_STRENGTH.get(), getShooter().getPosX() - e.getPosX(), getShooter().getPosZ() - e.getPosZ());
        }
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.PUSH.get());
    }
}
