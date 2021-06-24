package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.init.EffectInit;
import ihh.spellbound.init.ItemInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class LightningBolt extends SpellProjectile {
    public LightningBolt(EntityType<? extends LightningBolt> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
        entity.setEffectOnly(false);
        entity.setPosition(result.getPos().getX(), result.getPos().getY(), result.getPos().getZ());
        world.addEntity(entity);
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
        if (!((LivingEntity) result.getEntity()).isPotionActive(EffectInit.spell_shield) && !((LivingEntity) result.getEntity()).isPotionActive(EffectInit.lightning_shield)) {
            ((LivingEntity) result.getEntity()).addPotionEffect(new EffectInstance(Effects.WEAKNESS, Config.LIGHTNING_BOLT_DURATION.get()));
            result.getEntity().attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.LIGHTNING_BOLT_DAMAGE.get());
        }
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.LIGHTNING_BOLT.get());
    }
}
