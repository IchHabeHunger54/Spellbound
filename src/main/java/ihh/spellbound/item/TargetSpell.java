package ihh.spellbound.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeConfigSpec;

public abstract class TargetSpell extends Spell {
    public TargetSpell(ForgeConfigSpec.IntValue config) {
        super(config);
    }

    @Override
    protected LivingEntity getTarget(World world, PlayerEntity player) {
        LivingEntity result = null;
        for (Entity entity : world.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB(player.getPositionVec().add(0, player.getEyeHeight(), 0), player.getLookVec()).expand(0.5, 0.5, 0.5)))
            if (entity.canBeCollidedWith() && entity instanceof LivingEntity && !(entity instanceof ArmorStandEntity) && (result == null || Math.abs(player.getDistance(entity)) < Math.abs(player.getDistance(result))))
                result = (LivingEntity) entity;
        return result;
    }
}
