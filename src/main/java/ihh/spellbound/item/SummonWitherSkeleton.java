package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.server.ServerWorld;

public final class SummonWitherSkeleton extends Spell {
    public SummonWitherSkeleton() {
        super(Config.SUMMON_WITHER_SKELETON_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        WitherSkeletonEntity entity = new WitherSkeletonEntity(EntityType.WITHER_SKELETON, world);
        entity.setHeldItem(Hand.MAIN_HAND, new ItemStack(Items.STONE_SWORD));
        entity.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
        world.addEntity(entity);
        return true;
    }
}
