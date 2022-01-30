package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class LightningBolt extends SpellProjectile {
    public LightningBolt(EntityType<? extends LightningBolt> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        net.minecraft.world.entity.LightningBolt entity = new net.minecraft.world.entity.LightningBolt(EntityType.LIGHTNING_BOLT, level);
        entity.setVisualOnly(false);
        entity.setPos(result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ());
        level.addFreshEntity(entity);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.SPELL_SHIELD.get()) && !((LivingEntity) result.getEntity()).hasEffect(EffectInit.LIGHTNING_SHIELD.get())) {
            ((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, Config.LIGHTNING_BOLT_DURATION.get()));
            result.getEntity().hurt(DamageSource.LIGHTNING_BOLT, Config.LIGHTNING_BOLT_DAMAGE.get());
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.LIGHTNING_BOLT.get());
    }
}
