package ihh.spellbound.item;

import ihh.spellbound.Util;
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
        world.setDayTime((world.getDayTime() + world.rand.nextInt(24000)));
        for (BlockPos b : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), 32))
            if (world.getBlockState(b).getBlock() instanceof IGrowable)
                ((IGrowable) world.getBlockState(b).getBlock()).grow(world, world.rand, b, world.getBlockState(b));
        return true;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.ADVANCE_TIME;
    }
}
