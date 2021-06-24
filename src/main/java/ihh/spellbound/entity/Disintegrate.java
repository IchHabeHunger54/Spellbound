package ihh.spellbound.entity;

import ihh.spellbound.Config;
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

public class Disintegrate extends SpellProjectile {
    public Disintegrate(EntityType<? extends Disintegrate> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.spell_shield)) {
            result.getEntity().setFire(Config.DISINTEGRATE_DURATION.get());
            result.getEntity().attackEntityFrom(DamageSource.MAGIC, Config.DISINTEGRATE_DAMAGE.get());
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.DISINTEGRATE.get());
    }
}
