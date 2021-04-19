package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class IcyGrip extends TargetSpell {
    public IcyGrip() {
        super(Config.ICY_GRIP_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.COLD_SHIELD.get())) {
            for (BlockPos pos : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), Config.ICY_GRIP_HORIZONTAL.get(), Config.ICY_GRIP_VERTICAL.get(), (state, pos) -> !state.isSolid() && !state.hasOpaqueCollisionShape(world, pos) && state.getBlockHardness(world, pos) == 0 && !BlockTags.FLOWERS.contains(state.getBlock())))
                if (world.getBlockState(pos.down()).isOpaqueCube(world, pos.down()))
                    world.setBlockState(pos, Blocks.SNOW.getDefaultState());
            target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Config.ICY_GRIP_DURATION.get()));
            target.attackEntityFrom(DamageSource.MAGIC, Config.ICY_GRIP_DAMAGE.get());
            target.extinguish();
            return true;
        }
        return false;
    }
}
