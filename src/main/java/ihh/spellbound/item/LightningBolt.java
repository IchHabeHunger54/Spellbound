package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class LightningBolt extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!target.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !target.isPotionActive(EffectInit.LIGHTNING_SHIELD.get())) {
            world.addLightningBolt(new LightningBoltEntity(world, target.getPosX(), target.getPosY(), target.getPosZ(), false));
            return true;
        }
        return false;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.LIGHTNING_BOLT;
    }
}
