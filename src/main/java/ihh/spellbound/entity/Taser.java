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

public class Taser extends SpellProjectile {
    public Taser(EntityType<? extends Taser> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).hasEffect(EffectInit.lightning_shield)) {
            ((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, Config.TASER_DURATION.get()));
            result.getEntity().hurt(DamageSource.LIGHTNING_BOLT, Config.TASER_DAMAGE.get());
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.TASER.get());
    }
}
