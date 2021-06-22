package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LightType;
import net.minecraft.world.server.ServerWorld;

public final class Torchlight extends Spell {
    public Torchlight() {
        super(Config.TORCHLIGHT_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        if (world.getLightFor(LightType.BLOCK, player.getPosition()) < 8) {
            Util.replaceAirBlock(world, player.getPosition(), Blocks.TORCH);
            return true;
        }
        return false;
    }
}
