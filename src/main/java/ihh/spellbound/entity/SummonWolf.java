package ihh.spellbound.entity;

import ihh.spellbound.init.ItemInit;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class SummonWolf extends SpellProjectile {
    public SummonWolf(EntityType<? extends SummonWolf> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        Wolf e = new Wolf(EntityType.WOLF, level);
        e.setHealth(20);
        e.setOwnerUUID(getOwner().getUUID());
        e.setPos(getX(), getY(), getZ());
        e.setTame(true);
        level.addFreshEntity(e);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.SUMMON_WOLF.get());
    }
}
