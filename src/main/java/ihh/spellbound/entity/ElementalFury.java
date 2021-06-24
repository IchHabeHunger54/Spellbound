package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ElementalFury extends SpellProjectile {
    public ElementalFury(EntityType<? extends ElementalFury> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        for (BlockPos pos : Util.getBlocksInRange(world, result.getPos().getX(), result.getPos().getY(), result.getPos().getZ(), Config.COLD_BLAST_RANGE.get(), Blocks.AIR))
            if (world.getBlockState(pos.down()).isOpaqueCube(world, pos.down()))
                world.setBlockState(pos, Blocks.SNOW.getDefaultState());
        world.createExplosion(this, getPosX(), getPosY(), getPosZ(), 4, true, Explosion.Mode.BREAK);
        LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
        entity.setEffectOnly(false);
        entity.setPosition(result.getPos().getX(), result.getPos().getY(), result.getPos().getZ());
        world.addEntity(entity);
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.spell_shield)) {
            if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.cold_shield)) {
                ((LivingEntity) result.getEntity()).addPotionEffect(new EffectInstance(Effects.SLOWNESS, Config.COLD_BLAST_DURATION.get()));
                result.getEntity().attackEntityFrom(DamageSource.MAGIC, Config.COLD_BLAST_DAMAGE.get());
                result.getEntity().extinguish();
            }
            if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.fire_shield)) result.getEntity().attackEntityFrom(DamageSource.ON_FIRE, Config.GREATER_FIREBALL_DAMAGE.get());
            if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.lightning_shield)) {
                ((LivingEntity) result.getEntity()).addPotionEffect(new EffectInstance(Effects.WEAKNESS, Config.LIGHTNING_BOLT_DURATION.get()));
                result.getEntity().attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.LIGHTNING_BOLT_DAMAGE.get());
            }
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.ELEMENTAL_FURY.get());
    }
}
