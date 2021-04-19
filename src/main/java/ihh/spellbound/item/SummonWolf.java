package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class SummonWolf extends SelfSpell {
    public SummonWolf() {
        super(Config.SUMMON_WOLF_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        WolfEntity wolf = new WolfEntity(EntityType.WOLF, world);
        wolf.setTamed(true);
        wolf.setOwnerId(target.getUniqueID());
        wolf.setHealth(20);
        double x, z;
        do {
            x = target.getPosX() + world.rand.nextInt(Config.SUMMON_WOLF_OFFSET.get()) - world.rand.nextInt(Config.SUMMON_WOLF_OFFSET.get());
            z = target.getPosZ() + world.rand.nextInt(Config.SUMMON_WOLF_OFFSET.get()) - world.rand.nextInt(Config.SUMMON_WOLF_OFFSET.get());
        } while (!world.getBlockState(new BlockPos(x, target.getPosY(), z)).isAir());
        wolf.setPosition(x, target.getPosY(), z);
        world.addEntity(wolf);
        return true;
    }
}
