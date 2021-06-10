package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.server.ServerWorld;

public final class SummonWitherSkeleton extends Spell {
    public SummonWitherSkeleton() {
        super(Config.SUMMON_WITHER_SKELETON_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        WitherSkeletonEntity entity = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
        entity.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.STONE_SWORD));
        entity.setPosition(target.getPosX(), target.getPosY(), target.getPosZ());
        world.addEntity(entity);
        return true;
    }
}
