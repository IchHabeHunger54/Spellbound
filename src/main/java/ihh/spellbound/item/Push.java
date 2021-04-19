package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class Push extends SelfSpell {
    public Push() {
        super(Config.PUSH_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getMobsInRange(world, (PlayerEntity) target, Config.PUSH_HORIZONTAL.get(), Config.PUSH_VERTICAL.get())) {
                e.attackEntityFrom(DamageSource.MAGIC, Config.PUSH_DAMAGE.get());
                e.applyKnockback(Config.PUSH_STRENGTH.get(), target.getPosX() - e.getPosX(), target.getPosZ() - e.getPosZ());
                b = true;
            }
        return b;
    }
}
