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
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class AreaLightning extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getEntitiesInRange(world, (PlayerEntity) target, SpellConfig.AREA_LIGHTNING_HORIZONTAL.get(), SpellConfig.AREA_LIGHTNING_VERTICAL.get()))
                if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !(e.isPotionActive(EffectInit.LIGHTNING_SHIELD.get())) && world.canBlockSeeSky(e.getPosition().down())) {
                    e.attackEntityFrom(DamageSource.LIGHTNING_BOLT, SpellConfig.AREA_LIGHTNING_DAMAGE.get());
                    LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
                    entity.setEffectOnly(false);
                    entity.setPosition(e.getPosX(), e.getPosY(), e.getPosZ());
                    world.addEntity(entity);
                    b = true;
                }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.AREA_LIGHTNING;
    }
}
