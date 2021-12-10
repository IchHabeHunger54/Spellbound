package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class Disintegrate extends SpellProjectile {
    public Disintegrate(EntityType<? extends Disintegrate> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.spell_shield)) {
            result.getEntity().setRemainingFireTicks(Config.DISINTEGRATE_DURATION.get());
            result.getEntity().hurt(DamageSource.MAGIC, Config.DISINTEGRATE_DAMAGE.get());
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.DISINTEGRATE.get());
    }
}
