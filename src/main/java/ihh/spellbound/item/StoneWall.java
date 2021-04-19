package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import ihh.spellbound.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class StoneWall extends SelfSpell {
    public StoneWall() {
        super(Config.STONE_WALL_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        Direction direction = target.rotationPitch <= -60 ? Direction.UP : target.rotationPitch >= 60 ? Direction.DOWN : target.getAdjustedHorizontalFacing();
        int i = (Config.STONE_WALL_WIDTH.get() - 1) / 2;
        if (direction == Direction.UP) {
            for (int w = -i; w <= i; w++)
                for (int h = -i; h <= i; h++)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, Config.STONE_WALL_HEIGHT.get(), h)), Blocks.STONE) || b;
        } else if (direction == Direction.DOWN) {
            for (int w = -i; w <= i; w++)
                for (int h = -i; h <= i; h++)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, -1, h)), Blocks.STONE) || b;
        } else for (int w = -i + 1; w <= i + 1; w++)
            for (int h = 0; h < Config.STONE_WALL_HEIGHT.get(); h++) {
                if (direction == Direction.SOUTH)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(-i + 1, h, w)), Blocks.STONE) || b;
                if (direction == Direction.EAST)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, h, -i + 1)), Blocks.STONE) || b;
                if (direction == Direction.NORTH)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(i + 1, h, w)), Blocks.STONE) || b;
                if (direction == Direction.WEST)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, h, i + 1)), Blocks.STONE) || b;
            }
        return b;
    }
}
