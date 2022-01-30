package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class DimensionDoor extends Spell {
    public DimensionDoor() {
        super(Config.DIMENSION_DOOR_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        int amount = Config.DIMENSION_DOOR_MIN.get() + level.random.nextInt(Config.DIMENSION_DOOR_MAX.get() - Config.DIMENSION_DOOR_MIN.get());
        double x = 0, z = 0;
        switch (player.getMotionDirection()) {
            case NORTH -> {
                x = player.getX();
                z = player.getZ() - amount;
            }
            case EAST -> {
                x = player.getX() + amount;
                z = player.getZ();
            }
            case SOUTH -> {
                x = player.getX();
                z = player.getZ() + amount;
            }
            case WEST -> {
                x = player.getX() - amount;
                z = player.getZ();
            }
        }
        int y = 255;
        while (level.getBlockState(new BlockPos(x, y - 1, z)).isAir()) {
            y--;
        }
        player.moveTo(x, y, z);
        return true;
    }
}
