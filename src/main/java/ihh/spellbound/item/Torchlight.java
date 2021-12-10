package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;

public class Torchlight extends Spell {
    public Torchlight() {
        super(Config.TORCHLIGHT_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        if (level.getBrightness(LightLayer.BLOCK, player.getOnPos()) < 8) {
            Util.replaceAirBlock(level, player.getOnPos(), Blocks.TORCH);
            return true;
        }
        return false;
    }
}
