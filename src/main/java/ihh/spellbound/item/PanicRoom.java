package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.BlockInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class PanicRoom extends Spell {
    public PanicRoom() {
        super(Config.PANIC_ROOM_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        boolean b = false;
        for (int w = -Config.BEDROCK_WALL_HORIZONTAL.get(); w <= Config.BEDROCK_WALL_HORIZONTAL.get(); w++)
            for (int h = -Config.BEDROCK_WALL_HORIZONTAL.get(); h <= Config.BEDROCK_WALL_HORIZONTAL.get(); h++)
                b = Util.replaceAirBlock(level, new BlockPos(player.position().add(w, Config.BEDROCK_WALL_VERTICAL.get(), h)), BlockInit.DECAYING_BEDROCK.get()) || b;
        for (int w = -Config.BEDROCK_WALL_HORIZONTAL.get(); w <= Config.BEDROCK_WALL_HORIZONTAL.get(); w++)
            for (int h = -Config.BEDROCK_WALL_HORIZONTAL.get(); h <= Config.BEDROCK_WALL_HORIZONTAL.get(); h++)
                b = Util.replaceAirBlock(level, new BlockPos(player.position().add(w, -1, h)), BlockInit.DECAYING_BEDROCK.get()) || b;
        for (int w = -Config.BEDROCK_WALL_VERTICAL.get(); w <= Config.BEDROCK_WALL_VERTICAL.get(); w++)
            for (int h = 0; h < Config.BEDROCK_WALL_VERTICAL.get(); h++) {
                b = Util.replaceAirBlock(level, new BlockPos(player.position().add(w, h, Config.BEDROCK_WALL_VERTICAL.get())), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAirBlock(level, new BlockPos(player.position().add(Config.BEDROCK_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAirBlock(level, new BlockPos(player.position().add(w, h, -Config.BEDROCK_WALL_VERTICAL.get())), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAirBlock(level, new BlockPos(player.position().add(-Config.BEDROCK_WALL_VERTICAL.get(), h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
            }
        return b;
    }
}
