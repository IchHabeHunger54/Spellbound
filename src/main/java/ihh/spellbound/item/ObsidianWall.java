package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ObsidianWall extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        Direction direction = target.rotationPitch <= -60 ? Direction.UP : target.rotationPitch >= 60 ? Direction.DOWN : target.getAdjustedHorizontalFacing();
        if (direction == Direction.UP) {
            for (int w = -2; w < 3; w++)
                for (int h = -2; h < 3; h++)
                    if (!world.getBlockState(new BlockPos(target.getPositionVec().add(w, 3, h))).isOpaqueCube(world, new BlockPos(target.getPositionVec().add(w, 3, h))))
                        world.setBlockState(new BlockPos(target.getPositionVec().add(w, 3, h)), BlockInit.DECAYING_OBSIDIAN.get().getDefaultState());
        } else if (direction == Direction.DOWN) {
            for (int w = -2; w < 3; w++)
                for (int h = -2; h < 3; h++)
                    if (!world.getBlockState(new BlockPos(target.getPositionVec().add(w, -1, h))).isOpaqueCube(world, new BlockPos(target.getPositionVec().add(w, -1, h))))
                        world.setBlockState(new BlockPos(target.getPositionVec().add(w, -1, h)), BlockInit.DECAYING_OBSIDIAN.get().getDefaultState());
        } else for (int w = -3; w < 4; w++)
            for (int h = 0; h < 3; h++) {
                if (direction == Direction.SOUTH && !world.getBlockState(new BlockPos(target.getPositionVec().add(w, h, 3))).isOpaqueCube(world, new BlockPos(target.getPositionVec().add(w, h, 3))))
                    world.setBlockState(new BlockPos(target.getPositionVec().add(w, h, 3)), BlockInit.DECAYING_OBSIDIAN.get().getDefaultState());
                if (direction == Direction.WEST && !world.getBlockState(new BlockPos(target.getPositionVec().add(-3, h, w))).isOpaqueCube(world, new BlockPos(target.getPositionVec().add(-3, h, w))))
                    world.setBlockState(new BlockPos(target.getPositionVec().add(-3, h, w)), BlockInit.DECAYING_OBSIDIAN.get().getDefaultState());
                if (direction == Direction.NORTH && !world.getBlockState(new BlockPos(target.getPositionVec().add(w, h, -3))).isOpaqueCube(world, new BlockPos(target.getPositionVec().add(w, h, -3))))
                    world.setBlockState(new BlockPos(target.getPositionVec().add(w, h, -3)), BlockInit.DECAYING_OBSIDIAN.get().getDefaultState());
                if (direction == Direction.EAST && !world.getBlockState(new BlockPos(target.getPositionVec().add(3, h, w))).isOpaqueCube(world, new BlockPos(target.getPositionVec().add(3, h, w))))
                    world.setBlockState(new BlockPos(target.getPositionVec().add(3, h, w)), BlockInit.DECAYING_OBSIDIAN.get().getDefaultState());
            }
        return true;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.OBSIDIAN_WALL;
    }
}
