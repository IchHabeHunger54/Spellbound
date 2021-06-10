package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class IcyGrip extends Spell {
    public IcyGrip() {
        super(Config.ICY_GRIP_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.COLD_SHIELD.get())) {
            for (BlockPos pos : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), Config.ICY_GRIP_RANGE.get(), Blocks.AIR, Blocks.FIRE, Blocks.SNOW))
                if (world.getBlockState(pos.down()).isOpaqueCube(world, pos))
                    world.setBlockState(pos, Blocks.SNOW.getDefaultState());
            target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Config.ICY_GRIP_DURATION.get()));
            target.attackEntityFrom(DamageSource.MAGIC, Config.ICY_GRIP_DAMAGE.get());
            target.extinguish();
            return true;
        }
        return false;
    }
}
