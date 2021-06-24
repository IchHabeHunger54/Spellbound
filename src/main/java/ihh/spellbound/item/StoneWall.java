package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class StoneWall extends Spell {
    public StoneWall() {
        super(Config.STONE_WALL_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        boolean b = false;
        Direction d = player.rotationPitch <= -60 ? Direction.UP : player.rotationPitch >= 60 ? Direction.DOWN : player.getAdjustedHorizontalFacing();
        if (d == Direction.UP) {
            for (int w = -Config.STONE_WALL_HORIZONTAL.get(); w <= Config.STONE_WALL_HORIZONTAL.get(); w++)
                for (int h = -Config.STONE_WALL_HORIZONTAL.get(); h <= Config.STONE_WALL_HORIZONTAL.get(); h++)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, Config.STONE_WALL_VERTICAL.get(), h)), Blocks.STONE) || b;
        } else if (d == Direction.DOWN) {
            for (int w = -Config.STONE_WALL_HORIZONTAL.get(); w <= Config.STONE_WALL_HORIZONTAL.get(); w++)
                for (int h = -Config.STONE_WALL_HORIZONTAL.get(); h <= Config.STONE_WALL_HORIZONTAL.get(); h++)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, -1, h)), Blocks.STONE) || b;
        } else for (int w = -Config.STONE_WALL_VERTICAL.get(); w <= Config.STONE_WALL_VERTICAL.get(); w++)
            for (int h = 0; h < Config.STONE_WALL_VERTICAL.get(); h++) {
                if (d == Direction.SOUTH)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, h, Config.STONE_WALL_VERTICAL.get())), Blocks.STONE) || b;
                if (d == Direction.EAST)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(Config.STONE_WALL_VERTICAL.get(), h, w)), Blocks.STONE) || b;
                if (d == Direction.NORTH)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, h, -Config.STONE_WALL_VERTICAL.get())), Blocks.STONE) || b;
                if (d == Direction.WEST)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(-Config.STONE_WALL_VERTICAL.get(), h, w)), Blocks.STONE) || b;
            }
        return b;
    }
}
