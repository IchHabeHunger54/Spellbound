package ihh.spellbound.item;

import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class DimensionDoor extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        Direction direction = target.getHorizontalFacing();
        int amount = SpellConfig.DIMENSION_DOOR_MIN.get() + world.rand.nextInt(SpellConfig.DIMENSION_DOOR_MAX.get() - SpellConfig.DIMENSION_DOOR_MIN.get());
        double x = 0;
        double z = 0;
        if (direction == Direction.NORTH) {
            x = target.getPosX();
            z = target.getPosZ() - amount;
        } else if (direction == Direction.EAST) {
            x = target.getPosX() + amount;
            z = target.getPosZ();
        } else if (direction == Direction.SOUTH) {
            x = target.getPosX();
            z = target.getPosZ() + amount;
        } else if (direction == Direction.WEST) {
            x = target.getPosX() - amount;
            z = target.getPosZ();
        }
        int y = 255;
        while (world.isAirBlock(new BlockPos(x, y - 1, z))) y--;
        target.setPositionAndUpdate(x, y, z);
        return true;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.DIMENSION_DOOR;
    }
}
