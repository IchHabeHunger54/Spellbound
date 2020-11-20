package ihh.spellbound.item;

import ihh.spellbound.block.BlockUtil;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class AdvanceTime extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        world.setDayTime((world.getDayTime() + world.rand.nextInt(24000)));
        for (BlockPos b : BlockUtil.getBlocksInDistance(world, target.getPosX(), target.getPosY(), target.getPosZ(), 32))
            if (world.getBlockState(b).getBlock() instanceof IGrowable)
                ((IGrowable) world.getBlockState(b).getBlock()).grow(world, world.rand, b, world.getBlockState(b));
        return true;
    }

    @Override
    protected Time getTime() {
        return Time.THREE;
    }
}
