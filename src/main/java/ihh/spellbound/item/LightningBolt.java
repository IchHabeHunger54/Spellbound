package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class LightningBolt extends Spell {
    public LightningBolt() {
        super(Config.LIGHTNING_BOLT_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        if (!player.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !player.isPotionActive(EffectInit.LIGHTNING_SHIELD.get())) {
            player.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.LIGHTNING_BOLT_DAMAGE.get());
            LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
            entity.setEffectOnly(false);
            entity.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
            world.addEntity(entity);
            return true;
        }
        return false;
    }
}
