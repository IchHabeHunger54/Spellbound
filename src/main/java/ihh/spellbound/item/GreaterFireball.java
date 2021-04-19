package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class GreaterFireball extends SelfSpell {
    public GreaterFireball() {
        super(Config.GREATER_FIREBALL_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        FireballEntity entity = new FireballEntity(world, target, target.getLookVec().x, target.getLookVec().y, target.getLookVec().z);
        entity.setPosition(target.getPosX(), target.getPosY() + target.getEyeHeight(), target.getPosZ());
        world.addEntity(entity);
        return true;
    }
}
