package ihh.spellbound.item;

import ihh.spellbound.block.Util;
import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Push extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target instanceof PlayerEntity)
            for (LivingEntity e : Util.getEntitiesInRange(world, (PlayerEntity) target, SpellConfig.PUSH_HORIZONTAL.get(), SpellConfig.PUSH_VERTICAL.get())) {
                e.attackEntityFrom(DamageSource.MAGIC, SpellConfig.PUSH_DAMAGE.get());
                e.knockBack(target, SpellConfig.PUSH_STRENGTH.get(), target.getPosX() - e.getPosX(), target.getPosZ() - e.getPosZ());
                b = true;
            }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.PUSH;
    }
}
