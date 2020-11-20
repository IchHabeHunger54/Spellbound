package ihh.spellbound.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class InstantLevitation extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        target.setPositionAndUpdate(target.getPosX(), target.getPosY() + 4, target.getPosZ());
        return true;
    }

    @Override
    protected Time getDefaultTime() {
        return Time.ZERO;
    }
}
