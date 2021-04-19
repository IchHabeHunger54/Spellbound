package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class AdvanceTime extends SelfSpell {
    public AdvanceTime() {
        super(Config.ADVANCE_TIME_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        world.setDayTime((world.getDayTime() + Config.ADVANCE_TIME_MIN.get() + world.rand.nextInt(Config.ADVANCE_TIME_MAX.get() - Config.ADVANCE_TIME_MIN.get())));
        for (BlockPos b : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), Config.ADVANCE_TIME_HORIZONTAL.get(), Config.ADVANCE_TIME_VERTICAL.get(), (state, pos) -> state.getBlock() instanceof IGrowable))
            ((IGrowable) world.getBlockState(b).getBlock()).grow(world, world.rand, b, world.getBlockState(b));
        return true;
    }
}
