package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class WailOfTheSheWolf extends SpellProjectile {
    public WailOfTheSheWolf(EntityType<? extends WailOfTheSheWolf> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        for (LivingEntity e : Util.getEntitiesInRange(world, this, Config.AREA_LIGHTNING_RANGE.get()))
            if (!e.isPotionActive(EffectInit.spell_shield))
                e.attackEntityFrom(DamageSource.MAGIC, Config.WAIL_OF_THE_SHE_WOLF_DAMAGE.get());
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.WAIL_OF_THE_SHE_WOLF.get());
    }
}
