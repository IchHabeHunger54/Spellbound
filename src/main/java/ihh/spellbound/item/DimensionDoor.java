package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class DimensionDoor extends Spell {
    public DimensionDoor() {
        super(Config.DIMENSION_DOOR_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        int amount = Config.DIMENSION_DOOR_MIN.get() + world.rand.nextInt(Config.DIMENSION_DOOR_MAX.get() - Config.DIMENSION_DOOR_MIN.get());
        double x = 0, z = 0;
        switch (player.getAdjustedHorizontalFacing()) {
            case NORTH:
                x = player.getPosX();
                z = player.getPosZ() - amount;
                break;
            case EAST:
                x = player.getPosX() + amount;
                z = player.getPosZ();
                break;
            case SOUTH:
                x = player.getPosX();
                z = player.getPosZ() + amount;
                break;
            case WEST:
                x = player.getPosX() - amount;
                z = player.getPosZ();
                break;
        }
        int y = 255;
        while (world.isAirBlock(new BlockPos(x, y - 1, z))) y--;
        player.setPositionAndUpdate(x, y, z);
        return true;
    }
}
