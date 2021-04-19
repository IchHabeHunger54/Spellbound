package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.server.ServerWorld;

public final class SummonSkeleton extends TargetSpell {
    public SummonSkeleton() {
        super(Config.SUMMON_SKELETON_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        SkeletonEntity entity = new SkeletonEntity(EntityType.SKELETON, world);
        entity.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.BOW));
        entity.setPosition(target.getPosX(), target.getPosY(), target.getPosZ());
        world.addEntity(entity);
        return true;
    }
}
