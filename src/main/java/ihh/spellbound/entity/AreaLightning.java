package ihh.spellbound.entity;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
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

public class AreaLightning extends SpellProjectile {
    public AreaLightning(EntityType<? extends AreaLightning> type, World world) {
        super(type, world);
    }

    @Override
    protected void affectBlock(BlockRayTraceResult result) {
        for (LivingEntity e : Util.getEntitiesInRange(world, this, Config.AREA_LIGHTNING_RANGE.get()))
            if (!e.isPotionActive(EffectInit.spell_shield) && !(e.isPotionActive(EffectInit.lightning_shield)) && world.canBlockSeeSky(e.getPosition().down())) {
                e.addPotionEffect(new EffectInstance(Effects.WEAKNESS, Config.LIGHTNING_BOLT_DURATION.get()));
                e.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.AREA_LIGHTNING_DAMAGE.get());
                LightningBoltEntity l = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
                l.setEffectOnly(false);
                l.setPosition(e.getPosX(), e.getPosY(), e.getPosZ());
                world.addEntity(l);
            }
    }

    @Override
    protected void affectEntity(EntityRayTraceResult result) {
    }

    @Nonnull
    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.AREA_LIGHTNING.get());
    }
}
