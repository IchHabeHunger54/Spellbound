package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class InstantLevitation extends Spell {
    public InstantLevitation() {
        super(Config.AREA_LIGHTNING_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        target.setPositionAndUpdate(target.getPosX(), target.getPosY() + Config.INSTANT_LEVITATION_RANGE.get(), target.getPosZ());
        return true;
    }
}
