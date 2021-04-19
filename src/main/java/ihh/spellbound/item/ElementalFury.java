package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.server.ServerWorld;

public final class ElementalFury extends SelfSpell {
    public ElementalFury() {
        super(Config.ELEMENTAL_FURY_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getMobsInRange(world, (PlayerEntity) target, Config.ELEMENTAL_FURY_HORIZONTAL.get(), Config.ELEMENTAL_FURY_VERTICAL.get()))
                if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                    if (!e.isPotionActive(EffectInit.COLD_SHIELD.get())) {
                        if (world.getBlockState(e.getPosition().down()).isOpaqueCube(world, e.getPosition()))
                            world.setBlockState(e.getPosition(), Blocks.SNOW.getDefaultState());
                        target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, Config.COLD_BLAST_DURATION.get()));
                        target.attackEntityFrom(DamageSource.MAGIC, Config.COLD_BLAST_DAMAGE.get());
                        target.extinguish();
                        b = true;
                    }
                    if (!e.isPotionActive(EffectInit.FIRE_SHIELD.get())) {
                        FireballEntity entity = new FireballEntity(world, target, 0, -1, 0);
                        entity.setPosition(target.getPosX(), target.getPosY() + target.getEyeHeight(), target.getPosZ());
                        world.addEntity(entity);
                        b = true;
                    }
                    if (!e.isPotionActive(EffectInit.LIGHTNING_SHIELD.get()) && world.canBlockSeeSky(target.getPosition())) {
                        target.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.LIGHTNING_BOLT_DAMAGE.get());
                        Util.spawnLightning(world, target.getPosX(), target.getPosY(), target.getPosZ());
                        b = true;
                    }
                }
        return b;
    }
}
