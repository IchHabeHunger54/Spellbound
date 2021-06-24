package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class FlamingHands extends SpellProjectile {
    public FlamingHands(EntityType<? extends FlamingHands> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        for (BlockPos pos : Util.getBlocksInRange(world, result.getPos().getX(), result.getPos().getY(), result.getPos().getZ(), Config.FLAMING_HANDS_RANGE.get(), Blocks.AIR))
            world.setBlockState(pos, Blocks.FIRE.getDefaultState());
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).isPotionActive(EffectInit.fire_shield))
            result.getEntity().attackEntityFrom(DamageSource.ON_FIRE, Config.FLAMING_HANDS_DAMAGE.get());
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.FLAMING_HANDS.get());
    }
}
