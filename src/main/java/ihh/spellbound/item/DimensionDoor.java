package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class DimensionDoor extends Spell {
    public DimensionDoor() {
        super(Config.DIMENSION_DOOR_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        Direction direction = player.getHorizontalFacing();
        int amount = Config.DIMENSION_DOOR_MIN.get() + world.rand.nextInt(Config.DIMENSION_DOOR_MAX.get() - Config.DIMENSION_DOOR_MIN.get());
        double x = 0;
        double z = 0;
        if (direction == Direction.NORTH) {
            x = player.getPosX();
            z = player.getPosZ() - amount;
        } else if (direction == Direction.EAST) {
            x = player.getPosX() + amount;
            z = player.getPosZ();
        } else if (direction == Direction.SOUTH) {
            x = player.getPosX();
            z = player.getPosZ() + amount;
        } else if (direction == Direction.WEST) {
            x = player.getPosX() - amount;
            z = player.getPosZ();
        }
        int y = 255;
        while (world.isAirBlock(new BlockPos(x, y - 1, z))) y--;
        player.setPositionAndUpdate(x, y, z);
        return true;
    }
}
