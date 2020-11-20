package ihh.spellbound.item;

import ihh.spellbound.block.BlockUtil;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class FlamingHands extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.FIRE_SHIELD.get())) {
            for (BlockPos pos : BlockUtil.getBlocksInDistance(world, target.getPosX(), target.getPosY(), target.getPosZ(), 3, Blocks.AIR, Blocks.FIRE))
                world.setBlockState(pos, Blocks.FIRE.getDefaultState());
            return true;
        }
        return false;
    }

    @Override
    protected Time getTime() {
        return Time.ONE;
    }
}
