package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class FlamingHands extends TargetSpell {
    public FlamingHands() {
        super(Config.FLAMING_HANDS_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        for (BlockPos pos : Util.getBlocksInRange(world, target.getPosX(), target.getPosY(), target.getPosZ(), Config.FLAMING_HANDS_HORIZONTAL.get(), Config.FLAMING_HANDS_VERTICAL.get(), (state, pos) -> !state.isSolid() && state.hasOpaqueCollisionShape(world, pos) && state.getBlockHardness(world, pos) == 0 && !BlockTags.FLOWERS.contains(state.getBlock())))
            if (world.getBlockState(pos.down()).isOpaqueCube(world, pos))
                world.setBlockState(pos, Blocks.FIRE.getDefaultState());
        target.attackEntityFrom(DamageSource.IN_FIRE, Config.FLAMING_HANDS_DAMAGE.get());
        return true;
    }
}
