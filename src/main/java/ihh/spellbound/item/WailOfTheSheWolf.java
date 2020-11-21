package ihh.spellbound.item;

import ihh.spellbound.Util;
import ihh.spellbound.config.SpellTimeConfig;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class WailOfTheSheWolf extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target instanceof PlayerEntity)
            for (LivingEntity entity : Util.getEntitiesInRange(world, (PlayerEntity) target, 20, 20))
                if (!entity.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
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
