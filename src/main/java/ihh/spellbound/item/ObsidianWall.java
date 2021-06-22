package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.BlockInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class ObsidianWall extends Spell {
    public ObsidianWall() {
        super(Config.OBSIDIAN_WALL_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        boolean b = false;
        Direction d = player.rotationPitch <= -60 ? Direction.UP : player.rotationPitch >= 60 ? Direction.DOWN : player.getAdjustedHorizontalFacing();
        if (d == Direction.UP) {
            for (int w = -Config.STONE_WALL_HORIZONTAL.get(); w <= Config.STONE_WALL_HORIZONTAL.get(); w++)
                for (int h = -Config.STONE_WALL_HORIZONTAL.get(); h <= Config.STONE_WALL_HORIZONTAL.get(); h++)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, Config.STONE_WALL_VERTICAL.get(), h)), BlockInit.DECAYING_OBSIDIAN.get()) || b;
        } else if (d == Direction.DOWN) {
            for (int w = -Config.STONE_WALL_HORIZONTAL.get(); w <= Config.STONE_WALL_HORIZONTAL.get(); w++)
                for (int h = -Config.STONE_WALL_HORIZONTAL.get(); h <= Config.STONE_WALL_HORIZONTAL.get(); h++)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, -1, h)), BlockInit.DECAYING_OBSIDIAN.get()) || b;
        } else for (int w = -Config.STONE_WALL_VERTICAL.get(); w <= Config.STONE_WALL_VERTICAL.get(); w++)
            for (int h = 0; h < Config.STONE_WALL_VERTICAL.get(); h++) {
                if (d == Direction.SOUTH)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, h, Config.STONE_WALL_VERTICAL.get())), BlockInit.DECAYING_OBSIDIAN.get()) || b;
                if (d == Direction.EAST)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(-Config.STONE_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_OBSIDIAN.get()) || b;
                if (d == Direction.NORTH)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, h, -Config.STONE_WALL_VERTICAL.get())), BlockInit.DECAYING_OBSIDIAN.get()) || b;
                if (d == Direction.WEST)
                    b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(Config.STONE_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_OBSIDIAN.get()) || b;
            }
        return b;
    }
}
