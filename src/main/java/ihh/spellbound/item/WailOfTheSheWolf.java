package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellConfig;
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
            for (LivingEntity entity : Util.getEntitiesInRange(world, (PlayerEntity) target, SpellConfig.WAIL_OF_THE_SHE_WOLF_HORIZONTAL.get(), SpellConfig.WAIL_OF_THE_SHE_WOLF_VERTICAL.get()))
                if (!entity.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                    b = true;
                    entity.attackEntityFrom(DamageSource.MAGIC, SpellConfig.WAIL_OF_THE_SHE_WOLF_DAMAGE.get());
                }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.WAIL_OF_THE_SHE_WOLF;
    }
}
