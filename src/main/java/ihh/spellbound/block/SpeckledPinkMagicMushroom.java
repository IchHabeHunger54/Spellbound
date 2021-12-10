package ihh.spellbound.block;

import com.google.common.collect.Lists;
import ihh.spellbound.init.BlockInit;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;

public class SpeckledPinkMagicMushroom extends MagicMushroom {
    @Override
    protected ArrayList<Block> getMates() {
        return Lists.newArrayList(BlockInit.YELLOW_MAGIC_MUSHROOM.get());
    }

    @Override
    protected Block getChild(Block b) {
        return BlockInit.GRAY_MAGIC_MUSHROOM.get();
    }
}
