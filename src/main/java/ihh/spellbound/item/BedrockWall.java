package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import ihh.spellbound.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class BedrockWall extends SelfSpell {
    public BedrockWall() {
        super(Config.BEDROCK_WALL_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        Direction direction = target.rotationPitch <= -60 ? Direction.UP : target.rotationPitch >= 60 ? Direction.DOWN : target.getAdjustedHorizontalFacing();
        int i = (Config.BEDROCK_WALL_WIDTH.get() - 1) / 2;
        if (direction == Direction.UP) {
            for (int w = -i; w <= i; w++)
                for (int h = -i; h <= i; h++)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, Config.BEDROCK_WALL_HEIGHT.get(), h)), BlockInit.DECAYING_BEDROCK.get()) || b;
        } else if (direction == Direction.DOWN) {
            for (int w = -i; w <= i; w++)
                for (int h = -i; h <= i; h++)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, -1, h)), BlockInit.DECAYING_BEDROCK.get()) || b;
        } else for (int w = -i + 1; w <= i + 1; w++)
            for (int h = 0; h < Config.BEDROCK_WALL_HEIGHT.get(); h++) {
                if (direction == Direction.SOUTH)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(-i + 1, h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
                if (direction == Direction.EAST)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, h, -i + 1)), BlockInit.DECAYING_BEDROCK.get()) || b;
                if (direction == Direction.NORTH)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(i + 1, h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
                if (direction == Direction.WEST)
                    b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, h, i + 1)), BlockInit.DECAYING_BEDROCK.get()) || b;
            }
        return b;
    }
}
