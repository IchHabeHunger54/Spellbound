package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class WailOfTheSheWolf extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        for (Entity entity : world.getEntitiesWithinAABBExcludingEntity(target, new AxisAlignedBB(target.getPosX() - 20, target.getPosY() - 20, target.getPosZ() - 20, target.getPosX() + 20, target.getPosY() + 20, target.getPosZ() + 20)))
            if (entity instanceof LivingEntity && !((LivingEntity) entity).isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                b = true;
                entity.attackEntityFrom(DamageSource.MAGIC, 500);
            }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.WAIL_OF_THE_SHE_WOLF;
    }
}
