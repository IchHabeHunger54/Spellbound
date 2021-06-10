package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class ObsidianWall extends Spell {
    public ObsidianWall() {
        super(Config.OBSIDIAN_WALL_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        Direction d = target.rotationPitch <= -60 ? Direction.UP : target.rotationPitch >= 60 ? Direction.DOWN : target.getAdjustedHorizontalFacing();
        if (d == Direction.UP) {
            for (int w = -Config.STONE_WALL_HORIZONTAL.get(); w <= Config.STONE_WALL_HORIZONTAL.get(); w++)
                for (int h = -Config.STONE_WALL_HORIZONTAL.get(); h <= Config.STONE_WALL_HORIZONTAL.get(); h++)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(w, Config.STONE_WALL_VERTICAL.get(), h)), BlockInit.DECAYING_OBSIDIAN.get()) || b;
        } else if (d == Direction.DOWN) {
            for (int w = -Config.STONE_WALL_HORIZONTAL.get(); w <= Config.STONE_WALL_HORIZONTAL.get(); w++)
                for (int h = -Config.STONE_WALL_HORIZONTAL.get(); h <= Config.STONE_WALL_HORIZONTAL.get(); h++)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(w, -1, h)), BlockInit.DECAYING_OBSIDIAN.get()) || b;
        } else for (int w = -Config.STONE_WALL_VERTICAL.get(); w <= Config.STONE_WALL_VERTICAL.get(); w++)
            for (int h = 0; h < Config.STONE_WALL_VERTICAL.get(); h++) {
                if (d == Direction.SOUTH)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(w, h, Config.STONE_WALL_VERTICAL.get())), BlockInit.DECAYING_OBSIDIAN.get()) || b;
                if (d == Direction.EAST)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(-Config.STONE_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_OBSIDIAN.get()) || b;
                if (d == Direction.NORTH)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(w, h, -Config.STONE_WALL_VERTICAL.get())), BlockInit.DECAYING_OBSIDIAN.get()) || b;
                if (d == Direction.WEST)
                    b = Util.replaceAirBlock(world, new BlockPos(target.getPositionVec().add(Config.STONE_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_OBSIDIAN.get()) || b;
            }
        return b;
    }
}
