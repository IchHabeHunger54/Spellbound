package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class Disintegrate extends Spell {
    public Disintegrate() {
        super(Config.DISINTEGRATE_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        if (!player.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
            player.setFire(Config.DISINTEGRATE_DURATION.get());
            player.attackEntityFrom(DamageSource.MAGIC, Config.DISINTEGRATE_DAMAGE.get());
            return true;
        }
        return false;
    }
}
