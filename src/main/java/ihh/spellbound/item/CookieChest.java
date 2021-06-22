package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class CookieChest extends Spell {
    public CookieChest() {
        super(Config.COOKIE_CHEST_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        BlockPos pos = player.getPosition();
        switch (player.getAdjustedHorizontalFacing()) {
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
            world.setBlockState(pos, Blocks.CHEST.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, player.getAdjustedHorizontalFacing()));
            IInventory inv = ChestBlock.getChestInventory(((ChestBlock) world.getBlockState(pos).getBlock()), world.getBlockState(pos), world, pos, true);
            if (inv != null) for (int i = 0; i < inv.getSizeInventory(); i++)
                inv.setInventorySlotContents(i, new ItemStack(Items.COOKIE, 64));
            return true;
        }
        return false;
    }
}
