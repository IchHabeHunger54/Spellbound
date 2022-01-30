package ihh.spellbound.entity;

import ihh.spellbound.init.ItemInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class SummonWitherSkeleton extends SpellProjectile {
    public SummonWitherSkeleton(EntityType<? extends SummonWitherSkeleton> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        WitherSkeleton e = new WitherSkeleton(EntityType.WITHER_SKELETON, level);
        e.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.STONE_SWORD));
        e.setPos(getX(), getY(), getZ());
        level.addFreshEntity(e);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.SUMMON_WITHER_SKELETON.get());
    }
}
