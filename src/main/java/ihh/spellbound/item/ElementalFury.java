package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
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

public final class ElementalFury extends Spell {
    public ElementalFury() {
        super(Config.ELEMENTAL_FURY_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getEntitiesInRange(world, (PlayerEntity) target, Config.ELEMENTAL_FURY_HORIZONTAL.get(), Config.ELEMENTAL_FURY_VERTICAL.get()))
                if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                    e.attackEntityFrom(DamageSource.MAGIC, Config.COLD_BLAST_DAMAGE.get());
                    e.attackEntityFrom(DamageSource.ON_FIRE, Config.GREATER_FIREBALL_DAMAGE.get());
                    e.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.AREA_LIGHTNING_DAMAGE.get());
                    e.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Config.COLD_BLAST_DURATION.get()));
                    world.setBlockState(target.getPosition(), Blocks.FIRE.getDefaultState());
                    LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
                    entity.setEffectOnly(false);
                    entity.setPosition(e.getPosX(), e.getPosY(), e.getPosZ());
                    world.addEntity(entity);
                }
        return true;
    }
}
