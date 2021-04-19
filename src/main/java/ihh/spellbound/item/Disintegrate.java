package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class Disintegrate extends TargetSpell {
    public Disintegrate() {
        super(Config.DISINTEGRATE_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
            target.setFire(Config.DISINTEGRATE_DURATION.get());
            target.attackEntityFrom(DamageSource.MAGIC, Config.DISINTEGRATE_DAMAGE.get());
            return true;
        }
        return false;
    }
}
