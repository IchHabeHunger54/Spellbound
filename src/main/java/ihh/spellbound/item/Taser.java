package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class Taser extends Spell {
    public Taser() {
        super(Config.TASER_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        if (!player.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !player.isPotionActive(EffectInit.COLD_SHIELD.get())) {
            player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, Config.TASER_DURATION.get()));
            player.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.TASER_DAMAGE.get());
            return true;
        }
        return false;
    }
}
