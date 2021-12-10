package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.Nonnull;

public class FlamingHands extends SpellProjectile {
    public FlamingHands(EntityType<? extends FlamingHands> type, Level level) {
        super(type, level);
    }

    @Override
    protected void affectBlock(BlockHitResult result) {
        for (BlockPos pos : Util.getBlocksInRange(level, result.getBlockPos().getX(), result.getBlockPos().getY(), result.getBlockPos().getZ(), Config.FLAMING_HANDS_RANGE.get(), Blocks.AIR))
            level.setBlock(pos, Blocks.FIRE.defaultBlockState(), 3);
    }

    @Override
    protected void affectEntity(EntityHitResult result) {
        if (!((LivingEntity) result.getEntity()).hasEffect(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).hasEffect(EffectInit.fire_shield))
            result.getEntity().hurt(DamageSource.ON_FIRE, Config.FLAMING_HANDS_DAMAGE.get());
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.FLAMING_HANDS.get());
    }
}
