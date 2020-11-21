package ihh.spellbound.item;

import ihh.spellbound.Util;
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
            for (LivingEntity e : Util.getEntitiesInRange(world, (PlayerEntity) target, 10, 3)) {
                e.attackEntityFrom(DamageSource.MAGIC, 0);
                double deltaX = e.getPosX() - target.getPosX();
                double deltaZ = e.getPosZ() - target.getPosZ();
                while (deltaX * deltaX + deltaZ * deltaZ < 1E-4) {
                    deltaZ = (Math.random() - Math.random()) * 0.01;
                    deltaX = (Math.random() - Math.random()) * 0.01;
                }
                e.knockBack(target, 10, -deltaX, -deltaZ);
                b = true;
            }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.PUSH;
    }
}
