package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class Taser extends TargetSpell {
    public Taser() {
        super(Config.TASER_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.COLD_SHIELD.get())) {
            target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, Config.TASER_DURATION.get()));
            target.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.TASER_DAMAGE.get());
            return true;
        }
        return false;
    }
}
