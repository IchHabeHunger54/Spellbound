package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class AreaLightning extends Spell {
    public AreaLightning() {
        super(Config.AREA_LIGHTNING_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        boolean b = false;
        for (LivingEntity e : Util.getEntitiesInRange(world, player, Config.AREA_LIGHTNING_HORIZONTAL.get(), Config.AREA_LIGHTNING_VERTICAL.get()))
            if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !(e.isPotionActive(EffectInit.LIGHTNING_SHIELD.get())) && world.canBlockSeeSky(e.getPosition().down())) {
                e.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.AREA_LIGHTNING_DAMAGE.get());
                LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
                entity.setEffectOnly(false);
                entity.setPosition(e.getPosX(), e.getPosY(), e.getPosZ());
                world.addEntity(entity);
                b = true;
            }
        return b;
    }
}
