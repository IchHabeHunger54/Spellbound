package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class InstantLevitation extends Spell {
    public InstantLevitation() {
        super(Config.INSTANT_LEVITATION_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        player.moveTo(player.getX(), player.getY() + Config.INSTANT_LEVITATION_RANGE.get(), player.getZ());
        return true;
    }
}
