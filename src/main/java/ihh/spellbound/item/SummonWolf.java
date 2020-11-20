package ihh.spellbound.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class SummonWolf extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        WolfEntity wolf = new WolfEntity(EntityType.WOLF, world);
        wolf.setTamed(true);
        wolf.setOwnerId(target.getUniqueID());
        wolf.setHealth(20);
        wolf.setPosition(target.getPosX(), target.getPosY(), target.getPosZ());
        world.addEntity(wolf);
        return true;
    }

    @Override
    protected Time getDefaultTime() {
        return Time.ONE;
    }
}
