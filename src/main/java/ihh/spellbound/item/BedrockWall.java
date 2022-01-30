package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BedrockWall extends Spell {
    public BedrockWall() {
        super(Config.BEDROCK_WALL_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        boolean b = false;
        Direction d = player.getXRot() <= -60 ? Direction.UP : player.getXRot() >= 60 ? Direction.DOWN : player.getMotionDirection();
        if (d == Direction.UP) {
            for (int w = -Config.BEDROCK_WALL_HORIZONTAL.get(); w <= Config.BEDROCK_WALL_HORIZONTAL.get(); w++) {
                for (int h = -Config.BEDROCK_WALL_HORIZONTAL.get(); h <= Config.BEDROCK_WALL_HORIZONTAL.get(); h++) {
                    b = Util.replaceAirBlock(level, new BlockPos(player.position().add(w, Config.BEDROCK_WALL_VERTICAL.get(), h)), BlockInit.DECAYING_BEDROCK.get()) || b;
                }
            }
        } else if (d == Direction.DOWN) {
            for (int w = -Config.BEDROCK_WALL_HORIZONTAL.get(); w <= Config.BEDROCK_WALL_HORIZONTAL.get(); w++) {
                for (int h = -Config.BEDROCK_WALL_HORIZONTAL.get(); h <= Config.BEDROCK_WALL_HORIZONTAL.get(); h++) {
                    b = Util.replaceAirBlock(level, new BlockPos(player.position().add(w, -1, h)), BlockInit.DECAYING_BEDROCK.get()) || b;
                }
            }
        } else for (int w = -Config.BEDROCK_WALL_VERTICAL.get(); w <= Config.BEDROCK_WALL_VERTICAL.get(); w++) {
            for (int h = 0; h < Config.BEDROCK_WALL_VERTICAL.get(); h++) {
                if (d == Direction.SOUTH) {
                    b = Util.replaceAirBlock(level, new BlockPos(player.position().add(w, h, Config.BEDROCK_WALL_VERTICAL.get())), BlockInit.DECAYING_BEDROCK.get()) || b;
                }
                if (d == Direction.EAST) {
                    b = Util.replaceAirBlock(level, new BlockPos(player.position().add(Config.BEDROCK_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
                }
                if (d == Direction.NORTH) {
                    b = Util.replaceAirBlock(level, new BlockPos(player.position().add(w, h, -Config.BEDROCK_WALL_VERTICAL.get())), BlockInit.DECAYING_BEDROCK.get()) || b;
                }
                if (d == Direction.WEST) {
                    b = Util.replaceAirBlock(level, new BlockPos(player.position().add(-Config.BEDROCK_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
                }
            }
        }
        return b;
    }
}
