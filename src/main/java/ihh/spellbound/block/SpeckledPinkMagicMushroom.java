package ihh.spellbound.block;

import com.google.common.collect.Lists;
import ihh.spellbound.init.BlockInit;
import java.util.ArrayList;
import net.minecraft.block.Block;

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
