package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class Breach extends Spell {
    public Breach() {
        super(Config.BREACH_USE_DURATION, Type.TARGET);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        for (int x = -Config.BREACH_RANGE.get(); x <= Config.BREACH_RANGE.get(); x++)
            for (int z = -Config.BREACH_RANGE.get(); z <= Config.BREACH_RANGE.get(); z++)
                b = Util.replaceBlock(world, new BlockPos(target.getPositionVec().add(x, -1, z)), Blocks.AIR, true) || b;
        return b;
    }
}
