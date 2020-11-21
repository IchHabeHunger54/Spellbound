package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class AreaLightning extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        for (Entity e : world.getEntitiesWithinAABBExcludingEntity(target, new AxisAlignedBB(target.getPosX() - 40, target.getPosY() - 20, target.getPosZ() - 40, target.getPosX() + 40, target.getPosY() + 20, target.getPosZ() + 40)))
            if (e instanceof LivingEntity && !((LivingEntity) e).isPotionActive(EffectInit.SPELL_SHIELD.get()) && !(((LivingEntity) e).isPotionActive(EffectInit.LIGHTNING_SHIELD.get())) && world.canBlockSeeSky(e.getPosition().down())) {
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
