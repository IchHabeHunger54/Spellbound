package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class Fireball extends SelfSpell {
    public Fireball() {
        super(Config.FIREBALL_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        SmallFireballEntity entity = new SmallFireballEntity(world, target, target.getLookVec().x, target.getLookVec().y, target.getLookVec().z);
        entity.setPosition(target.getPosX(), target.getPosY() + target.getEyeHeight(), target.getPosZ());
        world.addEntity(entity);
        return true;
    }
}
