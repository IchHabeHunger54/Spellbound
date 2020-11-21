package ihh.spellbound.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public abstract class AbstractSelfSpell extends AbstractSpell {
    @Override
    protected LivingEntity getTarget(PlayerEntity player) {
        return player;
    }
}
