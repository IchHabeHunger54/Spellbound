package ihh.spellbound.block;

import com.google.common.collect.Lists;
import ihh.spellbound.init.BlockInit;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class SpeckledOrangeMagicMushroom extends MagicMushroom {
    @Override
    protected ArrayList<Block> getMates() {
        return Lists.newArrayList(BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get(), BlockInit.PURPLE_MAGIC_MUSHROOM.get());
    }

    @Override
    protected Block getChild(Block b) {
        return b == BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get() ? BlockInit.YELLOW_MAGIC_MUSHROOM.get() : BlockInit.RAINBOW_MAGIC_MUSHROOM.get();
    }
}
