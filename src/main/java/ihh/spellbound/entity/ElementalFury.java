package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class ElementalFury extends SpellProjectile {
    public ElementalFury(EntityType<? extends ElementalFury> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        for (BlockPos pos : Util.getBlocksInRange(level, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), Config.COLD_BLAST_RANGE.get(), Blocks.AIR)) {
            if (level.getBlockState(pos.below()).isSolidRender(level, pos.below())) {
                level.setBlock(pos, Blocks.SNOW.defaultBlockState(), 3);
            }
        }
        level.explode(this, getX(), getY(), getZ(), 4, true, Explosion.BlockInteraction.BREAK);
        net.minecraft.world.entity.LightningBolt entity = new net.minecraft.world.entity.LightningBolt(EntityType.LIGHTNING_BOLT, level);
        entity.setVisualOnly(false);
        entity.setPos(result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ());
        level.addFreshEntity(entity);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.SPELL_SHIELD.get())) {
            if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.COLD_SHIELD.get())) {
                ((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, Config.COLD_BLAST_DURATION.get()));
                result.getEntity().hurt(DamageSource.MAGIC, Config.COLD_BLAST_DAMAGE.get());
                result.getEntity().clearFire();
            }
            if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.FIRE_SHIELD.get())) {
                result.getEntity().hurt(DamageSource.ON_FIRE, Config.GREATER_FIREBALL_DAMAGE.get());
            }
            if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.LIGHTNING_SHIELD.get())) {
                ((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, Config.LIGHTNING_BOLT_DURATION.get()));
                result.getEntity().hurt(DamageSource.LIGHTNING_BOLT, Config.LIGHTNING_BOLT_DAMAGE.get());
            }
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.ELEMENTAL_FURY.get());
    }
}
