package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.server.ServerWorld;

public final class SummonSkeleton extends Spell {
    public SummonSkeleton() {
        super(Config.SUMMON_SKELETON_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        SkeletonEntity entity = new SkeletonEntity(EntityType.SKELETON, world);
        entity.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.BOW));
        entity.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
        world.addEntity(entity);
        return true;
    }
}
