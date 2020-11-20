package ihh.spellbound.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public abstract class AbstractTargetSpell extends AbstractSpell {
    @Override
    protected LivingEntity getTarget(PlayerEntity caster) {
        LivingEntity result = null;
        Vec3d vec = caster.getPositionVec().add(0, caster.getEyeHeight(), 0);
        Vec3d lookVec = caster.getLookVec();
        for (Entity entity : caster.world.getEntitiesWithinAABBExcludingEntity(caster, caster.getBoundingBox().expand(lookVec.getX() * 8, lookVec.getY() * 8, lookVec.getZ() * 8).grow(1, 1, 1))) {
            if (entity.canBeCollidedWith()) {
                float f = Math.max(1, entity.getCollisionBorderSize());
                AxisAlignedBB aabb = entity.getBoundingBox().grow(f, f, f);
                if ((aabb.intersects(lookVec.add(vec), vec)) || aabb.intersects(lookVec.subtract(vec), vec) && entity instanceof LivingEntity && (result == null || Math.abs(caster.getDistance(entity)) < Math.abs(caster.getDistance(result))))
                    result = (LivingEntity) entity;
            }
        }
        return result;
    }
}
