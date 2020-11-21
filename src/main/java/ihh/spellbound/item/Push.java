package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Push extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        for (Entity e : world.getEntitiesWithinAABBExcludingEntity(target, new AxisAlignedBB(target.getPosX() - 10, target.getPosY() - 3, target.getPosZ() - 10, target.getPosX() + 10, target.getPosY() + 3, target.getPosZ() + 10))) {
            if (e instanceof LivingEntity) {
                e.attackEntityFrom(DamageSource.causeIndirectMagicDamage(target, e), 0.0F);
                double deltaX = e.getPosX() - target.getPosX();
                double deltaZ = e.getPosZ() - target.getPosZ();
                while (deltaX * deltaX + deltaZ * deltaZ < 1.0E-4D) {
                    deltaZ = (Math.random() - Math.random()) * 0.01D;
                    deltaX = (Math.random() - Math.random()) * 0.01D;
                }
                for (int i = 0; i < 10; i++)
                    ((LivingEntity) e).knockBack(target, 10.0F, deltaX * -1, deltaZ * -1);
                b = true;
            }
        }
        return b;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.PUSH;
    }
}
