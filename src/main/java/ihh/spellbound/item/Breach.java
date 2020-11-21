package ihh.spellbound.item;

import ihh.spellbound.Util;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Breach extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target.isPotionActive(EffectInit.SURGE_SHIELD.get())) {
            target.removeActivePotionEffect(EffectInit.SURGE_SHIELD.get());
            b = true;
        }
        for (int x = -1; x <= 1; x++)
            for (int z = -1; z <= 1; z++)
                b = Util.replaceBlock(world, new BlockPos(target.getPositionVec().add(x, -1, z)), Blocks.AIR, true) || b;
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.BREACH;
    }
}
