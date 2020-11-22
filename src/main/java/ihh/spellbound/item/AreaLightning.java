package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class AreaLightning extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getEntitiesInRange(world, (PlayerEntity) target, 40, 20))
                if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !(e.isPotionActive(EffectInit.LIGHTNING_SHIELD.get())) && world.canBlockSeeSky(e.getPosition().down())) {
                    world.addLightningBolt(new LightningBoltEntity(world, e.getPosX(), e.getPosY(), e.getPosZ(), false));
                    b = true;
                }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.AREA_LIGHTNING;
    }
}
