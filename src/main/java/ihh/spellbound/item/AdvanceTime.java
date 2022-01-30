package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BonemealableBlock;

public class AdvanceTime extends Spell {
    public AdvanceTime() {
        super(Config.ADVANCE_TIME_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        level.setDayTime((level.getDayTime() + Config.ADVANCE_TIME_MIN.get() + level.random.nextInt(Math.max(Config.ADVANCE_TIME_MAX.get() - Config.ADVANCE_TIME_MIN.get(), 1))));
        if (Config.ADVANCE_TIME_RANGE.get() > 0) {
            for (BlockPos b : Util.getBlocksInRange(level, player.getX(), player.getY(), player.getZ(), Config.ADVANCE_TIME_RANGE.get(), b -> b.getBlock() instanceof BonemealableBlock)) {
                ((BonemealableBlock) level.getBlockState(b).getBlock()).performBonemeal(level, level.random, b, level.getBlockState(b));
            }
        }
        return true;
    }
}
