package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class WailOfTheSheWolf extends Spell {
    public WailOfTheSheWolf() {
        super(Config.WAIL_OF_THE_SHE_WOLF_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target instanceof PlayerEntity)
            for (LivingEntity entity : Util.getEntitiesInRange(world, (PlayerEntity) target, Config.WAIL_OF_THE_SHE_WOLF_HORIZONTAL.get(), Config.WAIL_OF_THE_SHE_WOLF_VERTICAL.get()))
                if (!entity.isPotionActive(EffectInit.SPELL_SHIELD.get())) {
                    b = true;
                    entity.attackEntityFrom(DamageSource.MAGIC, Config.WAIL_OF_THE_SHE_WOLF_DAMAGE.get());
                }
        return b;
    }
}
