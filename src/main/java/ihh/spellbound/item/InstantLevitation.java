package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class InstantLevitation extends SelfSpell {
    public InstantLevitation() {
        super(Config.INSTANT_LEVITATION_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        target.setPositionAndUpdate(target.getPosX(), target.getPosY() + Config.INSTANT_LEVITATION_HEIGHT.get(), target.getPosZ());
        return true;
    }
}
