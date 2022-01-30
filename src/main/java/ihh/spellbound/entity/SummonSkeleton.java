package ihh.spellbound.entity;

import ihh.spellbound.init.ItemInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class SummonSkeleton extends SpellProjectile {
    public SummonSkeleton(EntityType<? extends SummonSkeleton> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        Skeleton e = new Skeleton(EntityType.SKELETON, level);
        e.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.BOW));
        e.setPos(getX(), getY(), getZ());
        level.addFreshEntity(e);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.SUMMON_SKELETON.get());
    }
}
