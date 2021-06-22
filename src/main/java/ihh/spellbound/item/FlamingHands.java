package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class FlamingHands extends Spell {
    public FlamingHands() {
        super(Config.FLAMING_HANDS_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        if (!player.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !player.isPotionActive(EffectInit.FIRE_SHIELD.get())) {
            for (BlockPos pos : Util.getBlocksInRange(world, player.getPosX(), player.getPosY(), player.getPosZ(), Config.FLAMING_HANDS_RANGE.get(), Blocks.AIR))
                world.setBlockState(pos, Blocks.FIRE.getDefaultState());
            player.attackEntityFrom(DamageSource.ON_FIRE, Config.FLAMING_HANDS_DAMAGE.get());
            return true;
        }
        return false;
    }
}
