package ihh.spellbound.block;

import com.google.common.collect.Lists;
import ihh.spellbound.init.BlockInit;
import java.util.ArrayList;
import net.minecraft.block.Block;

public class WhiteMagicMushroom extends MagicMushroom {
    @Override
    protected ArrayList<Block> getMates() {
        return Lists.newArrayList(BlockInit.SPECKLED_RED_MAGIC_MUSHROOM.get(), BlockInit.SPECKLED_ORANGE_MAGIC_MUSHROOM.get(), BlockInit.SPECKLED_PINK_MAGIC_MUSHROOM.get(), BlockInit.SPECKLED_BLUE_MAGIC_MUSHROOM.get(), BlockInit.ORANGE_MAGIC_MUSHROOM.get(), BlockInit.PURPLE_MAGIC_MUSHROOM.get(), BlockInit.RAINBOW_MAGIC_MUSHROOM.get(), BlockInit.SPECKLED_ORANGE_MAGIC_MUSHROOM.get(), BlockInit.YELLOW_MAGIC_MUSHROOM.get());
    }

    @Override
    protected Block getChild(Block b) {
        return b;
    }
}
