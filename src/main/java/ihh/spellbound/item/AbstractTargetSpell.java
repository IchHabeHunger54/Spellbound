package ihh.spellbound.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;

public abstract class AbstractTargetSpell extends AbstractSpell {
    @Override
    protected LivingEntity getTarget(PlayerEntity player) {
        LivingEntity result = null;
        Vector3d vec = player.getPositionVec().add(0, player.getEyeHeight(), 0);
        Vector3d lookVec = player.getLookVec();
        for (Entity entity : player.world.getEntitiesWithinAABBExcludingEntity(player, player.getBoundingBox().expand(lookVec.getX() * 8, lookVec.getY() * 8, lookVec.getZ() * 8).grow(1, 1, 1))) {
            if (entity.canBeCollidedWith()) {
                float f = Math.max(1, entity.getCollisionBorderSize());
                AxisAlignedBB aabb = entity.getBoundingBox().grow(f, f, f);
                if ((aabb.intersects(lookVec.add(vec), vec)) || aabb.intersects(lookVec.subtract(vec), vec) && entity instanceof LivingEntity && (result == null || Math.abs(player.getDistance(entity)) < Math.abs(player.getDistance(result))))
                    result = (LivingEntity) entity;
            }
        }
        return result;
    }
}
