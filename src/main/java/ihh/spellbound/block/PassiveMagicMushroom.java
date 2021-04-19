package ihh.spellbound.block;

import net.minecraft.block.Block;

import java.util.ArrayList;

public class PassiveMagicMushroom extends MagicMushroom {
    @Override
    protected ArrayList<Block> getMates() {
        return new ArrayList<>();
    }

    @Override
    protected Block getChild(Block b) {
        return null;
    }
}
