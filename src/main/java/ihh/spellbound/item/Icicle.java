package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Icicle extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        Direction direction = target.getHorizontalFacing();
        boolean r = false;
        for (int i = 2; i < SpellConfig.ICICLE_RANGE.get(); i++) {
            int x = direction.getAxis() == Direction.Axis.X ? i : 0;
            int z = direction.getAxis() == Direction.Axis.Z ? i : 0;
            BlockPos pos = new BlockPos(direction == Direction.EAST ? target.getPosX() + x : direction == Direction.WEST ? target.getPosX() - x : target.getPosX(), target.getPosY(), direction == Direction.SOUTH ? target.getPosZ() + z : direction == Direction.NORTH ? target.getPosZ() - z : target.getPosZ());
            Block b = world.getBlockState(pos).getBlock();
            if (b.isAir(world.getBlockState(pos), world, pos) || b == Blocks.FIRE) {
                if (world.getBlockState(pos.down()).isOpaqueCube(world, pos.down()))
                    r = world.setBlockState(pos, Blocks.SNOW.getDefaultState()) || r;
            } else break;
            if (target instanceof PlayerEntity)
                for (LivingEntity e : Util.getEntitiesInRange(world, (PlayerEntity) target, SpellConfig.ICICLE_HORIZONTAL.get(), SpellConfig.ICICLE_VERTICAL.get()))
                    if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !e.isPotionActive(EffectInit.COLD_SHIELD.get())) {
                        e.addPotionEffect(new EffectInstance(Effects.SLOWNESS, SpellConfig.ICICLE_DURATION.get()));
                        e.attackEntityFrom(DamageSource.MAGIC, SpellConfig.ICICLE_DAMAGE.get());
                        e.extinguish();
                    }
        }
        return r;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.ICICLE;
    }
}
