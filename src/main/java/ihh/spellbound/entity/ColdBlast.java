package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ColdBlast extends SpellProjectile {
    public ColdBlast(EntityType<? extends ColdBlast> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        for (BlockPos pos : Util.getBlocksInRange(world, result.getPos().getX(), result.getPos().getY(), result.getPos().getZ(), Config.COLD_BLAST_RANGE.get(), Blocks.AIR))
            if (world.getBlockState(pos.down()).isOpaqueCube(world, pos.down()))
                world.setBlockState(pos, Blocks.SNOW.getDefaultState());
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).isPotionActive(EffectInit.cold_shield)) {
            ((LivingEntity) result.getEntity()).addPotionEffect(new EffectInstance(Effects.SLOWNESS, Config.COLD_BLAST_DURATION.get()));
            result.getEntity().attackEntityFrom(DamageSource.MAGIC, Config.COLD_BLAST_DAMAGE.get());
            result.getEntity().extinguish();
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.COLD_BLAST.get());
    }
}
