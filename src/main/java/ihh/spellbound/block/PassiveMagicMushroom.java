package ihh.spellbound.block;

import java.util.ArrayList;
import net.minecraft.block.Block;

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
