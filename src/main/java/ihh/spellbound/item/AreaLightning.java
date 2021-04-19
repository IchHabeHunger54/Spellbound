package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import ihh.spellbound.init.EffectInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class AreaLightning extends SelfSpell {
    public AreaLightning() {
        super(Config.AREA_LIGHTNING_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        for (LivingEntity e : Util.getMobsInRange(world, (PlayerEntity) target, Config.AREA_LIGHTNING_HORIZONTAL.get(), Config.AREA_LIGHTNING_VERTICAL.get())) {
            if (!e.isPotionActive(EffectInit.SPELL_SHIELD.get()) && !e.isPotionActive(EffectInit.LIGHTNING_SHIELD.get()) && world.canBlockSeeSky(e.getPosition())) {
                e.attackEntityFrom(DamageSource.LIGHTNING_BOLT, Config.AREA_LIGHTNING_DAMAGE.get());
                Util.spawnLightning(world, e.getPosX(), e.getPosY(), e.getPosZ());
                b = true;
            }
        }
        return b;
    }
}
