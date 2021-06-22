package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class Icicle extends Spell {
    public Icicle() {
        super(Config.ICICLE_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        if (!player.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !player.isPotionActive(EffectInit.COLD_SHIELD.get())) {
            for (BlockPos pos : Util.getBlocksInRange(world, player.getPosX(), player.getPosY(), player.getPosZ(), Config.ICICLE_RANGE.get(), Blocks.AIR))
                if (world.getBlockState(pos.down()).isOpaqueCube(world, pos.down()))
                    world.setBlockState(pos, Blocks.SNOW.getDefaultState());
            player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Config.ICICLE_DURATION.get()));
            player.attackEntityFrom(DamageSource.MAGIC, Config.ICICLE_DAMAGE.get());
            player.extinguish();
            return true;
        }
        return false;
    }
}
