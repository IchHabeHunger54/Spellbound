package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.server.ServerWorld;

public final class ElementalFury extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        for (LivingEntity e : world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(target.getPosX() - 8, target.getPosY() - 8, target.getPosZ() - 8, target.getPosX() + 8, target.getPosY() + 8, target.getPosZ() + 8)))
            if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                if (world.rand.nextBoolean()) {
                    e.attackEntityFrom(DamageSource.MAGIC, 15);
                    e.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 1200));
                } else if (world.rand.nextBoolean()) {
                    e.attackEntityFrom(DamageSource.MAGIC, 10);
                    e.setFire(15);
                    world.createExplosion(e, e.getPosX(), e.getPosY(), e.getPosZ(), 5, false, Explosion.Mode.BREAK);
                } else {
                    e.attackEntityFrom(DamageSource.MAGIC, 15);
                    world.addLightningBolt(new LightningBoltEntity(e.world, e.getPosX(), e.getPosY(), e.getPosZ(), false));
                }
            }
        return true;
    }

    @Override
    protected Time getDefaultTime() {
        return Time.FIVE;
    }
}
