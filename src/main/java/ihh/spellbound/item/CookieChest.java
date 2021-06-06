package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class CookieChest extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        BlockPos pos = target.getPosition();
        switch (target.getAdjustedHorizontalFacing()) {
            case EAST:
                pos = pos.east();
                break;
            case SOUTH:
                pos = pos.south();
                break;
            case WEST:
                pos = pos.west();
                break;
            case NORTH:
                pos = pos.north();
                break;
        }
        if (world.isAirBlock(pos)) {
            world.setBlockState(pos, Blocks.CHEST.getDefaultState());
            IInventory inv = ChestBlock.getChestInventory(((ChestBlock) world.getBlockState(pos).getBlock()), world.getBlockState(pos), world, pos, true);
            if (inv != null) for (int i = 0; i < inv.getSizeInventory(); i++)
                inv.setInventorySlotContents(i, new ItemStack(Items.COOKIE, 64));
            return true;
        }
        return false;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.COOKIE_CHEST;
    }
}
