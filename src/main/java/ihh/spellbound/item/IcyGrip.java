package ihh.spellbound.item;

import ihh.spellbound.block.BlockUtil;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class IcyGrip extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.COLD_SHIELD.get())) {
            for (BlockPos pos : BlockUtil.getBlocksInDistance(world, target.getPosX(), target.getPosY(), target.getPosZ(), 3, Blocks.AIR, Blocks.FIRE, Blocks.SNOW))
                if (world.getBlockState(pos.down()).isOpaqueCube(world, pos))
                    world.setBlockState(pos, Blocks.SNOW.getDefaultState());
            target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 1200));
            target.attackEntityFrom(DamageSource.MAGIC, 4);
            target.extinguish();
            return true;
        }
        return false;
    }

    @Override
    protected Time getTime() {
        return Time.ONE;
    }
}
