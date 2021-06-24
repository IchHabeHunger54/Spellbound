package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.BlockInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class PanicRoom extends Spell {
    public PanicRoom() {
        super(Config.PANIC_ROOM_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        boolean b = false;
        for (int w = -Config.BEDROCK_WALL_HORIZONTAL.get(); w <= Config.BEDROCK_WALL_HORIZONTAL.get(); w++)
            for (int h = -Config.BEDROCK_WALL_HORIZONTAL.get(); h <= Config.BEDROCK_WALL_HORIZONTAL.get(); h++)
                b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, Config.BEDROCK_WALL_VERTICAL.get(), h)), BlockInit.DECAYING_BEDROCK.get()) || b;
        for (int w = -Config.BEDROCK_WALL_HORIZONTAL.get(); w <= Config.BEDROCK_WALL_HORIZONTAL.get(); w++)
            for (int h = -Config.BEDROCK_WALL_HORIZONTAL.get(); h <= Config.BEDROCK_WALL_HORIZONTAL.get(); h++)
                b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, -1, h)), BlockInit.DECAYING_BEDROCK.get()) || b;
        for (int w = -Config.BEDROCK_WALL_VERTICAL.get(); w <= Config.BEDROCK_WALL_VERTICAL.get(); w++)
            for (int h = 0; h < Config.BEDROCK_WALL_VERTICAL.get(); h++) {
                b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, h, Config.BEDROCK_WALL_VERTICAL.get())), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(Config.BEDROCK_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(w, h, -Config.BEDROCK_WALL_VERTICAL.get())), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAirBlock(world, new BlockPos(player.getPositionVec().add(-Config.BEDROCK_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
            }
        return b;
    }
}
