package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;

public final class Push extends Spell {
    public Push() {
        super(Config.PUSH_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        boolean b = false;
        for (LivingEntity e : Util.getEntitiesInRange(world, player, Config.PUSH_HORIZONTAL.get(), Config.PUSH_VERTICAL.get())) {
            e.attackEntityFrom(DamageSource.MAGIC, Config.PUSH_DAMAGE.get());
            e.applyKnockback(Config.PUSH_STRENGTH.get(), player.getPosX() - e.getPosX(), player.getPosZ() - e.getPosZ());
            b = true;
        }
        return b;
    }
}
