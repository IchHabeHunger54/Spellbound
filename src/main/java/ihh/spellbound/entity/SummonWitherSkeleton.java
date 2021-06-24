package ihh.spellbound.entity;

import ihh.spellbound.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SummonWitherSkeleton extends SpellProjectile {
    public SummonWitherSkeleton(EntityType<? extends SummonWitherSkeleton> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        WitherSkeletonEntity e = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
        e.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.STONE_SWORD));
        e.setPosition(getShooter().getPosX(), getShooter().getPosY(), getShooter().getPosZ());
        world.addEntity(e);
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.SUMMON_WITHER_SKELETON.get());
    }
}
