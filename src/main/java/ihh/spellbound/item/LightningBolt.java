package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class LightningBolt extends Spell {
    public LightningBolt() {
        super(Config.LIGHTNING_BOLT_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.LIGHTNING_SHIELD.get())) {
            target.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.LIGHTNING_BOLT_DAMAGE.get());
            LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
            entity.setEffectOnly(false);
            entity.setPosition(target.getPosX(), target.getPosY(), target.getPosZ());
            world.addEntity(entity);
            return true;
        }
        return false;
    }
}
