package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class Taser extends SpellProjectile {
    public Taser(EntityType<? extends Taser> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).isPotionActive(EffectInit.lightning_shield)) {
            ((LivingEntity) result.getEntity()).addPotionEffect(new EffectInstance(Effects.WEAKNESS, Config.TASER_DURATION.get()));
            result.getEntity().attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.TASER_DAMAGE.get());
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.TASER.get());
    }
}
