package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class GreaterFireball extends Spell {
    public GreaterFireball() {
        super(Config.GREATER_FIREBALL_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        if (!player.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !player.isPotionActive(EffectInit.FIRE_SHIELD.get())) {
            FireballEntity entity = new FireballEntity(world, player, player.getLookVec().x, player.getLookVec().y, player.getLookVec().z);
            entity.setPosition(entity.getPosX(), entity.getPosY() + player.getEyeHeight(), entity.getPosZ());
            world.addEntity(entity);
            return true;
        }
        return false;
    }
}
