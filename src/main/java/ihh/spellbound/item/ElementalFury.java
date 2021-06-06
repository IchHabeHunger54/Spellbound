package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ElementalFury extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getEntitiesInRange(world, (PlayerEntity) target, SpellConfig.ELEMENTAL_FURY_HORIZONTAL.get(), SpellConfig.ELEMENTAL_FURY_VERTICAL.get()))
                if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                    int r = world.rand.nextInt(3);
                    if (r == 0) {
                        e.attackEntityFrom(DamageSource.MAGIC, SpellConfig.COLD_BLAST_DAMAGE.get());
                        e.addPotionEffect(new EffectInstance(Effects.SLOWNESS, SpellConfig.COLD_BLAST_DURATION.get()));
                    }
                    if (r == 1) {
                        e.attackEntityFrom(DamageSource.ON_FIRE, SpellConfig.GREATER_FIREBALL_DAMAGE.get());
                        world.createExplosion(e, e.getPosX(), e.getPosY(), e.getPosZ(), 5, true, Explosion.Mode.BREAK);
                    }
                    if (r == 2) {
                        e.attackEntityFrom(DamageSource.LIGHTNING_BOLT, SpellConfig.AREA_LIGHTNING_DAMAGE.get());
                        LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
                        entity.setEffectOnly(false);
                        entity.setPosition(e.getPosX(), e.getPosY(), e.getPosZ());
                        world.addEntity(entity);
                    }
                }
        return true;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.ELEMENTAL_FURY;
    }
}
