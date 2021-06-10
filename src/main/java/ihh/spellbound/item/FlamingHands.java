package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class FlamingHands extends Spell {
    public FlamingHands() {
        super(Config.FLAMING_HANDS_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.FIRE_SHIELD.get())) {
            for (BlockPos pos : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), Config.FLAMING_HANDS_RANGE.get(), Blocks.AIR, Blocks.FIRE))
                world.setBlockState(pos, Blocks.FIRE.getDefaultState());
            return true;
        }
        return false;
    }
}
