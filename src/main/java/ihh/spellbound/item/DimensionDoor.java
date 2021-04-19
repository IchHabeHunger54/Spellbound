package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class DimensionDoor extends SelfSpell {
    public DimensionDoor() {
        super(Config.DIMENSION_DOOR_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        Direction direction = target.getHorizontalFacing();
        int amount = Config.DIMENSION_DOOR_MIN.get() + world.rand.nextInt(Config.DIMENSION_DOOR_MAX.get() - Config.DIMENSION_DOOR_MIN.get());
        double x = target.getPosX();
        double z = target.getPosZ();
        if (direction == Direction.EAST) x += amount;
        if (direction == Direction.SOUTH) z += amount;
        if (direction == Direction.WEST) x -= amount;
        if (direction == Direction.NORTH) z -= amount;
        int y = 255;
        while (world.isAirBlock(new BlockPos(x, y - 1, z))) y--;
        target.setPositionAndUpdate(x, y, z);
        return true;
    }
}
