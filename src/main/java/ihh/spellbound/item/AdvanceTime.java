package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class AdvanceTime extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        world.setDayTime((world.getDayTime() + Math.max(SpellConfig.ADVANCE_TIME_MIN.get(), 1) + world.rand.nextInt(Math.max(SpellConfig.ADVANCE_TIME_MAX.get() - SpellConfig.ADVANCE_TIME_MIN.get(), 1))));
        if (SpellConfig.ADVANCE_TIME_RANGE.get() > 0)
            for (BlockPos b : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), SpellConfig.ADVANCE_TIME_RANGE.get()))
                if (world.getBlockState(b).getBlock() instanceof IGrowable)
                    ((IGrowable) world.getBlockState(b).getBlock()).grow(world, world.rand, b, world.getBlockState(b));
        return true;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.ADVANCE_TIME;
    }
}
