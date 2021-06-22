package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class InstantLevitation extends Spell {
    public InstantLevitation() {
        super(Config.AREA_LIGHTNING_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        player.setPositionAndUpdate(player.getPosX(), player.getPosY() + Config.INSTANT_LEVITATION_RANGE.get(), player.getPosZ());
        return true;
    }
}
