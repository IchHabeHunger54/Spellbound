package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class AdvanceTime extends Spell {
    public AdvanceTime() {
        super(Config.ADVANCE_TIME_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        world.setDayTime((world.getDayTime() + Math.max(Config.ADVANCE_TIME_MIN.get(), 1) + world.rand.nextInt(Math.max(Config.ADVANCE_TIME_MAX.get() - Config.ADVANCE_TIME_MIN.get(), 1))));
        if (Config.ADVANCE_TIME_RANGE.get() > 0)
            for (BlockPos b : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), Config.ADVANCE_TIME_RANGE.get()))
                if (world.getBlockState(b).getBlock() instanceof IGrowable)
                    ((IGrowable) world.getBlockState(b).getBlock()).grow(world, world.rand, b, world.getBlockState(b));
        return true;
    }
}
