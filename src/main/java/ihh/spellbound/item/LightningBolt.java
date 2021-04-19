package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class LightningBolt extends TargetSpell {
    public LightningBolt() {
        super(Config.LIGHTNING_BOLT_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.LIGHTNING_SHIELD.get()) && world.canBlockSeeSky(target.getPosition())) {
            target.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.LIGHTNING_BOLT_DAMAGE.get());
            Util.spawnLightning(world, target.getPosX(), target.getPosY(), target.getPosZ());
            return true;
        }
        return false;
    }
}
