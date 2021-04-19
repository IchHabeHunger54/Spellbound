package ihh.spellbound.block;

import com.google.common.collect.Lists;
import ihh.spellbound.init.BlockInit;
import net.minecraft.block.Block;

import java.util.ArrayList;

public class SpeckledRedMagicMushroom extends MagicMushroom {
    @Override
    protected ArrayList<Block> getMates() {
        return Lists.newArrayList(BlockInit.SPECKLED_ORANGE_MAGIC_MUSHROOM.get(), BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get(), BlockInit.SPECKLED_BLUE_MAGIC_MUSHROOM.get(), BlockInit.LIGHT_BLUE_MAGIC_MUSHROOM.get());
    }

    @Override
    protected Block getChild(Block b) {
        return b == BlockInit.SPECKLED_ORANGE_MAGIC_MUSHROOM.get() ? BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get() : b == BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get() ? BlockInit.SPECKLED_BLUE_MAGIC_MUSHROOM.get() : b == BlockInit.SPECKLED_BLUE_MAGIC_MUSHROOM.get() ? BlockInit.PURPLE_MAGIC_MUSHROOM.get() : BlockInit.GOLD_MAGIC_MUSHROOM.get();
    }
}
