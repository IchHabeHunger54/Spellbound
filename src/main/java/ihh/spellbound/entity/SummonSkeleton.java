package ihh.spellbound.entity;

import ihh.spellbound.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SummonSkeleton extends SpellProjectile {
    public SummonSkeleton(EntityType<? extends SummonSkeleton> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        SkeletonEntity e = new SkeletonEntity(EntityType.SKELETON, world);
        e.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.BOW));
        e.setPosition(getShooter().getPosX(), getShooter().getPosY(), getShooter().getPosZ());
        world.addEntity(e);
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.SUMMON_SKELETON.get());
    }
}
