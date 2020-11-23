package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class FlamingHands extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.FIRE_SHIELD.get())) {
            for (BlockPos pos : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), SpellConfig.FLAMING_HANDS_RANGE.get(), Blocks.AIR, Blocks.FIRE))
                world.setBlockState(pos, Blocks.FIRE.getDefaultState());
            return true;
        }
        return false;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.FLAMING_HANDS;
    }
}
