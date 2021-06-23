package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.entity.BreachEntity;
import ihh.spellbound.init.EntityInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class Breach extends Spell {
    public Breach() {
        super(Config.BREACH_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        BreachEntity entity = new BreachEntity(EntityInit.BREACH.get(), player.getPosX(), player.getPosY() + player.getEyeHeight(), player.getPosZ(), world);
        entity.setDirectionAndMovement(player, player.rotationPitch, player.rotationYaw, -20.0F, 0.7F, 1.0F);
        world.addEntity(entity);
        return true;
    }
}
