package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class CookieChest extends Spell {
    public CookieChest() {
        super(Config.COOKIE_CHEST_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        player.getOnPos();
        BlockPos pos = switch (player.getMotionDirection()) {
            case EAST -> player.getOnPos().east();
            case SOUTH -> player.getOnPos().south();
            case WEST -> player.getOnPos().west();
            case NORTH -> player.getOnPos().north();
            default -> player.getOnPos();
        };
        if (level.getBlockState(pos).isAir()) {
            level.setBlock(pos, Blocks.CHEST.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, player.getMotionDirection().getOpposite()), 3);
            Container inv = ChestBlock.getContainer(((ChestBlock) level.getBlockState(pos).getBlock()), level.getBlockState(pos), level, pos, true);
            if (inv != null) for (int i = 0; i < inv.getContainerSize(); i++)
                inv.setItem(i, new ItemStack(Items.COOKIE, 64));
            return true;
        }
        return false;
    }
}
