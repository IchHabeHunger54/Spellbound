package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
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

public class AreaLightning extends SpellProjectile {
    public AreaLightning(EntityType<? extends AreaLightning> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        for (LivingEntity e : Util.getEntitiesInRange(level, this, Config.AREA_LIGHTNING_RANGE.get())) {
            if (!e.hasEffect(EffectInit.SPELL_SHIELD.get()) && !e.hasEffect(EffectInit.LIGHTNING_SHIELD.get()) && (level.canSeeSky(e.blockPosition().below()) || level.canSeeSky(e.blockPosition()))) {
                e.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, Config.LIGHTNING_BOLT_DURATION.get()));
                e.hurt(DamageSource.LIGHTNING_BOLT, Config.AREA_LIGHTNING_DAMAGE.get());
                net.minecraft.world.entity.LightningBolt l = new net.minecraft.world.entity.LightningBolt(EntityType.LIGHTNING_BOLT, level);
                l.setVisualOnly(false);
                l.setPos(e.getX(), e.getY(), e.getZ());
                level.addFreshEntity(l);
            }
        }
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.AREA_LIGHTNING.get());
    }
}
