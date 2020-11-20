package ihh.spellbound.block;

import java.util.Random;
import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class DecayingBlock extends Block {
    public DecayingBlock(Block b) {
        super(Block.Properties.from(b));
    }

    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerWorld worldIn, @Nonnull BlockPos pos, Random rand) {
        if (rand.nextBoolean()) worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
    }

    @Override
    public boolean ticksRandomly(@Nonnull BlockState state) {
        return true;
    }
}
