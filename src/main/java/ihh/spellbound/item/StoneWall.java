package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class StoneWall extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        Direction direction = target.rotationPitch <= -60 ? Direction.UP : target.rotationPitch >= 60 ? Direction.DOWN : target.getAdjustedHorizontalFacing();
        if (direction == Direction.UP) {
            for (int w = -2; w < 3; w++)
                for (int h = -2; h < 3; h++)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(w, 3, h)), Blocks.STONE) || b;
        } else if (direction == Direction.DOWN) {
            for (int w = -2; w < 3; w++)
                for (int h = -2; h < 3; h++)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(w, -1, h)), Blocks.STONE) || b;
        } else for (int w = -3; w < 4; w++)
            for (int h = 0; h < 3; h++) {
                if (direction == Direction.SOUTH)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(w, h, 3)), Blocks.STONE) || b;
                if (direction == Direction.EAST)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(-3, h, w)), Blocks.STONE) || b;
                if (direction == Direction.NORTH)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(w, h, -3)), Blocks.STONE) || b;
                if (direction == Direction.WEST)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(3, h, w)), Blocks.STONE) || b;
            }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.STONE_WALL;
    }
}
