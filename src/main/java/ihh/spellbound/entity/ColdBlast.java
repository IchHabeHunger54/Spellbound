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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class ColdBlast extends SpellProjectile {
    public ColdBlast(EntityType<? extends ColdBlast> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        for (BlockPos pos : Util.getBlocksInRange(level, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), Config.COLD_BLAST_RANGE.get(), Blocks.AIR))
            if (level.getBlockState(pos.below()).isSolidRender(level, pos.below()))
                level.setBlock(pos, Blocks.SNOW.defaultBlockState(), 3);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).hasEffect(EffectInit.cold_shield)) {
            ((LivingEntity) result.getEntity()).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, Config.COLD_BLAST_DURATION.get()));
            result.getEntity().hurt(DamageSource.MAGIC, Config.COLD_BLAST_DAMAGE.get());
            result.getEntity().clearFire();
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.COLD_BLAST.get());
    }
}
