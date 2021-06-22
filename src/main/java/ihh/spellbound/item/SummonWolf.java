package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class SummonWolf extends Spell {
    public SummonWolf() {
        super(Config.SUMMON_WOLF_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        WolfEntity wolf = new WolfEntity(EntityType.WOLF, world);
        wolf.setTamed(true);
        wolf.setOwnerId(player.getUniqueID());
        wolf.setHealth(20);
        wolf.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
        world.addEntity(wolf);
        return true;
    }
}
